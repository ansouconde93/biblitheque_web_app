package soa.gestion.livre.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import soa.gestion.livre.entities.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByType(String type);
}
