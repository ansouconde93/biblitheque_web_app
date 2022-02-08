package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.Auteurs;
import soa.gestion.livre.entities.Livre;

import java.util.List;

public interface AuteursRepository extends JpaRepository<Auteurs, Long> {
    List<Livre> findByLivres(Auteurs auteur);
}
