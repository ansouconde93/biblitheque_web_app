package soa.gestion.livre.services.serviceInterfaces;

import soa.gestion.livre.entities.Livre;

import java.util.List;

public interface LivreService {
    Livre saveLivre(Livre livre);

    Livre getLivreById(Long id);
    List<Livre> getLivresByCode(String code);

    Livre deleteLivre(Long id);

    Livre updateLivre(Livre livre, Long id);
    List<Livre> getAll();

}
