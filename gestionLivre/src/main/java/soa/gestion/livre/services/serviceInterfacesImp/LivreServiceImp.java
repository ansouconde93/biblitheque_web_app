package soa.gestion.livre.services.serviceInterfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.livre.Dao.LivreRepository;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.services.serviceInterfaces.LivreService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class LivreServiceImp implements LivreService {

    @Autowired
    private LivreRepository livreRepository;
    @Override
    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    @Override
    public Livre getLivreById(Long id) {
        Optional<Livre> livre = livreRepository.findById(id);
        if(livre.isPresent())
            return livre.get();
        return null;
    }

    @Override
    public List<Livre> getLivresByCode(String code) {
        return livreRepository.findByCode(code);
    }

    @Override
    public Livre deleteLivre(Long id) {
        Optional<Livre> livre = livreRepository.findById(id);
        if(livre.isPresent()){
            livreRepository.deleteById(id);
            return livre.get();
        }
        return null;
    }

    @Override
    public Livre updateLivre(Livre livre, Long id) {
        if (livreRepository.findById(id).isPresent()){
            livre.setId(id);
            return livreRepository.save(livre);
        }
        return null;
    }

    @Override
    public List<Livre> getAll() {
        return livreRepository.findAll();
    }
}
