package soa.gestion.membre.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.membre.entities.AppUsers;

public interface AppUsersRepository extends JpaRepository<AppUsers, Long> {
    AppUsers findByEmail(String email);
    AppUsers findByTelephone(String telephone);
    AppUsers findByMatricule(String matricule);
}
