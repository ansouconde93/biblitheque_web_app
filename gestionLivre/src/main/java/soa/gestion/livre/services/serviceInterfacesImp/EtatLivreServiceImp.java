package soa.gestion.livre.services.serviceInterfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.livre.Dao.EtatLivreRepository;
import soa.gestion.livre.entities.EtatLivre;
import soa.gestion.livre.services.serviceInterfaces.EtatLivreService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class EtatLivreServiceImp implements EtatLivreService {
    @Autowired
    private EtatLivreRepository etatLivreRepository;

    @Override
    public EtatLivre save(EtatLivre etatLivre) {
        return etatLivreRepository.save(etatLivre);
    }

    @Override
    public EtatLivre getById(Long id) {
        Optional<EtatLivre> etatLivre = etatLivreRepository.findById(id);
        if(etatLivre.isPresent())
            return etatLivre.get();
        return null;
    }

    @Override
    public List<EtatLivre> getAll() {
        return etatLivreRepository.findAll();
    }

    @Override
    public EtatLivre delete(Long id) {
        Optional<EtatLivre> etatLivre = etatLivreRepository.findById(id);
        if(etatLivre.isPresent()) {
            etatLivreRepository.deleteById(id);
            etatLivre.get();
        }
        return null;
    }

    @Override
    public EtatLivre update(EtatLivre etatLivre, Long id) {
        if(etatLivreRepository.findById(id).isPresent()){
            etatLivre.setId(id);
            return etatLivreRepository.save(etatLivre);
        }
        return null;
    }
}
