package soa.gestion.administration.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRole(String role);
}
