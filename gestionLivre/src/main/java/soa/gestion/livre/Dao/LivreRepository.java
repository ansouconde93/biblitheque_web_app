package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.Livre;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByCode(String code);

}
