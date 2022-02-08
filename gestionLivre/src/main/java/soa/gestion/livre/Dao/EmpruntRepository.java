package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.Emprunt;
import soa.gestion.livre.entities.Livre;

import java.util.List;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Livre> findByLivreAndDateretourIsNull(Livre livre);
}
