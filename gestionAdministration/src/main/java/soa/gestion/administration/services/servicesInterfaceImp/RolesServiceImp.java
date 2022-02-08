package soa.gestion.administration.services.servicesInterfaceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.administration.DAO.RolesRepository;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.services.servicesInterface.AutorisationsService;
import soa.gestion.administration.services.servicesInterface.RolesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class RolesServiceImp implements RolesService {

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private AutorisationsService autorisationsService;

    @Override
    public Roles save(Roles role) {
        List<Autorisations> autorisations = role.getAutorisations();
        Roles roles = new Roles();
        roles.setId(null);
        roles.setRole(role.getRole());
        //roles = rolesRepository.save(roles);
        List<Autorisations> autorisations2 = new ArrayList<>();
        if (autorisations != null){
            autorisations.forEach(autorisations1 -> {
                if (autorisationsService.getByAutority(autorisations1.getAutority()) == null){
                    autorisations1.setId(null);
                    autorisationsService.save(autorisations1);
                }
                autorisations2.add(autorisationsService.getByAutority(autorisations1.getAutority()));
            });

        }
        rolesRepository.save(roles).setAutorisations(autorisations2);
        return rolesRepository.findByRole(roles.getRole());
    }

    @Override
    public Roles getById(Long id) {
        Optional<Roles> roles = rolesRepository.findById(id);
        if (roles.isPresent()){
            roles.get();
        }
        return null;
    }

    @Override
    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles getByRole(String role) {
        return rolesRepository.findByRole(role);
    }

    @Override
    public List<Autorisations> getAutorisationsByRole(Long idRole) {
        return rolesRepository.findById(idRole).get().getAutorisations();
    }

    @Override
    public Roles delete(Long id) {
        Optional<Roles> role = rolesRepository.findById(id);
        if (role.isPresent()){
            rolesRepository.deleteById(id);
            return role.get();
        }
        return null;
    }

    @Override
    public Roles update(Roles role, Long id) {
        if (rolesRepository.findById(id).isPresent()){
            role.setId(id);
            return rolesRepository.save(role);
        }
        return null;
    }
}
