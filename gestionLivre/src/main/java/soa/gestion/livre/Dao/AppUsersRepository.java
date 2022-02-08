package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.Emprunt;
import soa.gestion.livre.entities.AppUsers;

import java.util.List;

public interface AppUsersRepository extends JpaRepository<AppUsers, Long> {
    List<Emprunt> findByEmprunts(AppUsers appUsers);
}
