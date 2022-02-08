package soa.gestion.administration.services.servicesInterfaceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.administration.DAO.MembreRepository;
import soa.gestion.administration.DAO.RolesRepository;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Membre;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.modele.MembreRole;
import soa.gestion.administration.services.servicesInterface.MembreService;

import java.util.*;

@Service
@Transactional

public class MembreServiceImp implements MembreService {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public int save(Long idMembre, List<String> listRolesName) {
        Optional<Membre> membre1 = membreRepository.findById(idMembre);
        Membre membre;
        if (membre1.isPresent()){
            Membre finalMembre = membre1.get();
            listRolesName.forEach(roleName ->{
                finalMembre.getRoles().add(rolesRepository.findByRole(roleName));
            });
            membre = membreRepository.save(finalMembre);
        }else {
            membre = new Membre();
            membre.setId(idMembre);
            Membre finalMembre = membre;
            listRolesName.forEach(roleName ->{
                finalMembre.getRoles().add(rolesRepository.findByRole(roleName));
            });
            membre = membreRepository.save(finalMembre);
        }
        if(membre != null)
            return 1;
        return 0;
    }

    @Override
    public List<Roles> getRolesByMembre(Long idMembre) {
        Membre membre = membreRepository.findById(idMembre).get();
        if ((membre != null))
            return membre.getRoles();
        return null;
    }

    @Override
    public Set<String> getMembreAutorities(Long idMembre) {
        Set<String> membreAutorities = new HashSet<>();
        Optional<Membre> membre = membreRepository.findById(idMembre);

        if ((membre.isPresent())){
            membre.get().getRoles().forEach(roles -> {
                for (Autorisations autorisation : roles.getAutorisations()) {
                    membreAutorities.add(autorisation.getAutority());
                }
            });
        }
        return membreAutorities;
    }

    @Override
    public int delete(Long id) {
        Optional<Membre> membre = membreRepository.findById(id);
        if (membre.isPresent())
            membreRepository.deleteById(id);
        if(membre.isPresent())
            return 1;
        return 0;
    }

    @Override
    public int suspendreCeMembreAvecCeRole(MembreRole membreRole) {
        Optional<Membre> membre = membreRepository.findById(membreRole.getIdMembre());
        membre.get().getRoles().forEach(roles -> {
            if (roles.getId() == membre.get().getId()){
                roles.setSusppendu(false);
                return;
            }
        });
        if(membre.isPresent())
            return 1;
        return 0;
    }

    @Override
    public int activerMembreSuspendu(MembreRole membreRole) {
        Optional<Membre> membre = membreRepository.findById(membreRole.getIdMembre());
        membre.get().getRoles().forEach(roles -> {
            if (roles.getId() == membre.get().getId()){
                roles.setSusppendu(true);
                return;
            }
        });
        if(membre.isPresent())
            return 1;
        return 0;
    }
}
