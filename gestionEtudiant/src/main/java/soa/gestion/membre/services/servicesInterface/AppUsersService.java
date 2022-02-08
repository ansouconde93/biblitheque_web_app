package soa.gestion.membre.services.servicesInterface;

import soa.gestion.membre.entities.AppUsers;
import soa.gestion.membre.modele.UserWithRoles;

import java.util.List;

public interface AppUsersService {
    AppUsers save(UserWithRoles userWithRoles);
    AppUsers getByEmail(String email);
    AppUsers getByTelephone(String telephone);
    AppUsers getByMatricule(String matricule);
    List<AppUsers> getAll();

    AppUsers delete(Long id);
    AppUsers update(AppUsers appUsers, Long id);
}
