package soa.gestion.livre.services.serviceInterfaces;

import soa.gestion.livre.entities.EtatLivre;

import java.util.List;

public interface EtatLivreService {
    EtatLivre save(EtatLivre etatLivre);
    EtatLivre getById(Long id);
    List<EtatLivre> getAll();
    EtatLivre delete(Long id);
    EtatLivre update(EtatLivre etatLivre, Long id);
}
