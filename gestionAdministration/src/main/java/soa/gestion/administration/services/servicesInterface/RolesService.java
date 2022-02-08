package soa.gestion.administration.services.servicesInterface;

import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;

import java.util.List;

public interface RolesService {
    Roles save(Roles role);
    Roles getById(Long id);
    List<Roles> getAll();
    Roles getByRole(String role);
    List<Autorisations> getAutorisationsByRole(Long idRole);
    Roles delete(Long id);
    Roles update(Roles role, Long id);
}
