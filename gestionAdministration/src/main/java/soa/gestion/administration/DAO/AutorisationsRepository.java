package soa.gestion.administration.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.administration.entities.Autorisations;

public interface AutorisationsRepository extends JpaRepository<Autorisations, Long> {
    Autorisations findByAutority(String autority);
}
