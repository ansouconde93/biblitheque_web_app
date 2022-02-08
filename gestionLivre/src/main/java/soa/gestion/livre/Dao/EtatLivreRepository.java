package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.EtatLivre;

public interface EtatLivreRepository extends JpaRepository<EtatLivre, Long> {
}
