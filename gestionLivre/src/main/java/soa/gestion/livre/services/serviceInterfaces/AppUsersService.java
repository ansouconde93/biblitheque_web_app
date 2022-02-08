package soa.gestion.livre.services.serviceInterfaces;

import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.modele.EmpruntLivre;

import java.util.List;

public interface AppUsersService {
    Livre emprunterLivre(EmpruntLivre empruntLivre);
    List<Livre> getLivrePreterByEtudiantNonRendu(Long idEtudiant);
    Livre rendreUnLivre(EmpruntLivre empruntLivre);
    void rappelerEtudiantNayantPasRenduLivre(EmpruntLivre empruntLivre);
    List<EmpruntLivre> getTousLivresEmprunterNonRendu();
}
