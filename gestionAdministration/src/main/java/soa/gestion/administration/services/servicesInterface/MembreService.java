package soa.gestion.administration.services.servicesInterface;

import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.modele.MembreRole;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MembreService {

    int save(Long idMembre, List<String> listRolesName);
    List<Roles> getRolesByMembre(Long idMembre);
    Set<String> getMembreAutorities(Long idMembre);
    int delete(Long id);
    int suspendreCeMembreAvecCeRole(MembreRole membreRole);
    int activerMembreSuspendu(MembreRole membreRole);
}
