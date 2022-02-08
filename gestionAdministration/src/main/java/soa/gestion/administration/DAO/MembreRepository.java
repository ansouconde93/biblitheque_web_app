package soa.gestion.administration.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.administration.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}
