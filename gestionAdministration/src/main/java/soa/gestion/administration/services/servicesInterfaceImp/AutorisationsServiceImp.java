package soa.gestion.administration.services.servicesInterfaceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.administration.DAO.AutorisationsRepository;
import soa.gestion.administration.DAO.RolesRepository;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.services.servicesInterface.AutorisationsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AutorisationsServiceImp implements AutorisationsService {
    @Autowired
    private AutorisationsRepository autorisationsRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public Autorisations save(Autorisations autorisation) {
        return autorisationsRepository.save(autorisation);
    }

    @Override
    public Autorisations getById(Long id) {
        Optional<Autorisations> autorisations = autorisationsRepository.findById(id);
        if (autorisations.isPresent())
            return autorisations.get();
        return null;
    }

    @Override
    public List<Autorisations> getAll() {
        return autorisationsRepository.findAll();
    }

    @Override
    public Autorisations getByAutority(String autority) {
        return autorisationsRepository.findByAutority(autority);
    }

    @Override
    public Autorisations delete(Long id) {
        Optional<Autorisations> autorisation = autorisationsRepository.findById(id);
        if(autorisation.isPresent()){
            List<Roles> roles = rolesRepository.findAll();
            if (roles != null){
                List<Autorisations> autorisations = new ArrayList<>();
                for (Roles role: roles){
                    List<Autorisations> finalAutorisations = autorisations;
                    role.getAutorisations().forEach(autorisations1 -> {
                        if (autorisations1.getId() != id){
                            finalAutorisations.add(autorisations1);
                        }
                    });
                    role.setAutorisations(finalAutorisations);
                    rolesRepository.save(role);
                    autorisations = new ArrayList<>();
                }
            }
            autorisationsRepository.deleteById(id);
            return autorisation.get();
        }
        return null;
    }

    @Override
    public Autorisations update(Autorisations autorisation, Long id) {
        if (autorisationsRepository.findById(id).isPresent()){
            autorisation.setId(id);
            return autorisationsRepository.save(autorisation);
        }
        return null;
    }

    @Override
    public void suspendreAutority(Long idAutorite) {
        Optional<Autorisations> autorisations = autorisationsRepository.findById(idAutorite);
        if (autorisations.isPresent())
            autorisations.get().setSusppendu(false);
    }

    @Override
    public void activerAutorisationSuspendu(Long idAutorite) {
        Optional<Autorisations> autorisations = autorisationsRepository.findById(idAutorite);
        if (autorisations.isPresent())
            autorisations.get().setSusppendu(true);
    }
}
