package soa.gestion.livre.services.serviceInterfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.livre.Dao.AuteursRepository;
import soa.gestion.livre.entities.Auteurs;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.services.serviceInterfaces.AuteursService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AuteursServiceImp implements AuteursService {

    @Autowired
    private AuteursRepository auteursRepository;

    @Override
    public Auteurs save(Auteurs auteurs) {
        return auteursRepository.save(auteurs);
    }

    @Override
    public Auteurs getById(Long id) {
        Optional<Auteurs> auteurs = auteursRepository.findById(id);
        if (auteurs.isPresent())
            return auteurs.get();
        return null;
    }

    @Override
    public List<Livre> getAllLivreByAuteurs(Long id) {
        Auteurs auteur = auteursRepository.findById(id).get();
        if(auteur != null){
            return auteursRepository.findByLivres(auteur);
        }
        return null;
    }

    @Override
    public Auteurs delete(Long id) {
        Optional<Auteurs> auteur = auteursRepository.findById(id);
        if (auteur.isPresent()) {
            auteursRepository.deleteById(id);
            return auteur.get();
        }
        return null;
    }

    @Override
    public Auteurs update(Auteurs auteur, Long id) {
        if (auteursRepository.findById(id).isPresent()){
            auteur.setId(id);
            return auteursRepository.save(auteur);
        }
        return null;
    }
}
