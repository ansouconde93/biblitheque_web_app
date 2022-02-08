package soa.gestion.livre.services.serviceInterfaces;

import soa.gestion.livre.entities.Auteurs;
import soa.gestion.livre.entities.EtatLivre;
import soa.gestion.livre.entities.Livre;

import java.util.List;

public interface AuteursService {

    Auteurs save(Auteurs auteurs);
    Auteurs getById(Long id);
    List<Livre> getAllLivreByAuteurs(Long id);
    Auteurs delete(Long id);
    Auteurs update(Auteurs auteurs, Long id);
}
