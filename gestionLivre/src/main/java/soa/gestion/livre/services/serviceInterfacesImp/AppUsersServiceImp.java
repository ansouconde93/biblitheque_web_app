package soa.gestion.livre.services.serviceInterfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.livre.Dao.EmpruntRepository;
import soa.gestion.livre.Dao.AppUsersRepository;
import soa.gestion.livre.entities.Emprunt;
import soa.gestion.livre.entities.AppUsers;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.modele.EmpruntLivre;
import soa.gestion.livre.services.serviceInterfaces.AppUsersService;
import soa.gestion.livre.services.serviceInterfaces.LivreService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional

public class AppUsersServiceImp implements AppUsersService {
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Autowired
    private LivreService livreService;
    @Autowired
    private EmpruntRepository empruntRepository;

    /*
    emprunter un livre
     */
    @Override
    public Livre emprunterLivre(EmpruntLivre empruntLivre) {
        Livre livre = livreService.getLivreById(empruntLivre.getIdlivre());
        if (livre != null){
            if (empruntRepository.findByLivreAndDateretourIsNull(livre).size() < livre.getNombreexemplaire()){
                Emprunt emprunt = new Emprunt();
                emprunt.setId(null);
                emprunt.setDateemprunt(new Date());
                emprunt.setDateretour(null);
                emprunt.setNombreRappel(0);
                emprunt.setLivre(livre);
                emprunt = empruntRepository.save(emprunt);
                AppUsers appUsers1 = new AppUsers();
                Optional<AppUsers> etudiant = appUsersRepository.findById(empruntLivre.getIdappuser());
                if (etudiant.isPresent()){
                    appUsers1 = etudiant.get();
                    appUsers1.getEmprunts().add(emprunt);
                }else {
                    appUsers1.setId(empruntLivre.getIdappuser());
                    appUsers1.getEmprunts().add(emprunt);
                }
                appUsersRepository.save(appUsers1);
                return livre;
            }
            return null;
        }
        return null;
    }

    /*
    Le ou les livre(s) emprunter par l'étudiant idEtudiant et non rendu
     */
    @Override
    public List<Livre> getLivrePreterByEtudiantNonRendu(Long idEtudiant) {
        List<Livre> livres = new ArrayList<>();
        AppUsers appUsers = appUsersRepository.findById(idEtudiant).get();
        if (appUsers != null){
            appUsers.getEmprunts().forEach(emprunt ->{
                if (emprunt.getDateretour() == null)
                    livres.add(emprunt.getLivre());
            });
        }
        return livres;
    }

    /*
    rendre un livre prèté par l'étudiant
     */
    @Override
    public Livre rendreUnLivre(EmpruntLivre empruntLivre) {
        AtomicReference<Livre> livr = null;
        AppUsers appUsers = appUsersRepository.findById(empruntLivre.getIdappuser()).get();
        if (appUsers != null){
            appUsers.getEmprunts().forEach(emprunt ->{
                if (emprunt.getLivre().getId() == empruntLivre.getIdlivre() && emprunt.getDateretour() == null) {
                    emprunt.setDateretour(new Date());
                    livr.set(emprunt.getLivre());
                }
            });
        }
        if (livr != null)
            return  null;
        return livr.get();
    }

    /*
    rappeler l'étudiant n'ayant pas rendu le livre
     */
    @Override
    public void rappelerEtudiantNayantPasRenduLivre(EmpruntLivre empruntLivre) {
        AppUsers appUsers = appUsersRepository.findById(empruntLivre.getIdappuser()).get();
        if (appUsers != null){
            appUsers.getEmprunts().forEach(emprunt ->{
                if (emprunt.getLivre().getId() == empruntLivre.getIdlivre() && emprunt.getDateretour() == null) {
                    emprunt.setDateretour(new Date());
                    emprunt.setNombreRappel(emprunt.getNombreRappel() + 1);
                }
            });
        }
    }
/*
avoir tous les id des livres emprunter er l'id de leur emprunteur
 */
    @Override
    public List<EmpruntLivre> getTousLivresEmprunterNonRendu() {
        List<AppUsers> appUsers;
        List<EmpruntLivre> empruntLivres = new ArrayList<>();
        appUsers = appUsersRepository.findAll();
        if (appUsers != null){
            appUsers.forEach(appUser -> {
                appUser.getEmprunts().forEach(emprunt -> {
                    if (emprunt.getDateemprunt() ==null){
                        empruntLivres.add(new EmpruntLivre(appUser.getId(), emprunt.getLivre().getId()));
                    }
                });
            });
        }
        return empruntLivres;
    }
}

