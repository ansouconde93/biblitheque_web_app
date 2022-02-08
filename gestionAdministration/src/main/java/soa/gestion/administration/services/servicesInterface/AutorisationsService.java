package soa.gestion.administration.services.servicesInterface;

import soa.gestion.administration.entities.Autorisations;

import java.util.List;

public interface AutorisationsService {
    Autorisations save(Autorisations autorisations);
    Autorisations getById(Long id);
    List<Autorisations> getAll();
    Autorisations getByAutority(String autority);
    Autorisations delete(Long id);
    Autorisations update(Autorisations autorisation, Long id);
    void suspendreAutority(Long idAutorite);
    void activerAutorisationSuspendu(Long idAutorite);
}
