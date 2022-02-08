package soa.gestion.membre.services.servicesInterfaceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.membre.DAO.AppUsersRepository;
import soa.gestion.membre.entities.AppUsers;
import soa.gestion.membre.modele.UserWithRoles;
import soa.gestion.membre.services.servicesAppeler.AdministrationSerciceClient;
import soa.gestion.membre.services.servicesInterface.AppUsersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional

public class AppUsersServiceImp implements AppUsersService {
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Autowired
    private AdministrationSerciceClient administrationSerciceClient;
    @Override
    public AppUsers save(UserWithRoles userWithRoles) {
        AppUsers appUser = appUsersRepository.save(userWithRoles.getAppUser());
        if (appUser!=null){
            Map<Long, List<String>> longStringMap = new HashMap<>();

            longStringMap.put(appUser.getId(),userWithRoles.getRolesName());
            administrationSerciceClient.save(longStringMap);
        }
        return appUser;
    }

    @Override
    public AppUsers getByEmail(String email) {
        return appUsersRepository.findByEmail(email);
    }

    @Override
    public AppUsers getByTelephone(String telephone) {
        return appUsersRepository.findByTelephone(telephone);
    }

    @Override
    public AppUsers getByMatricule(String matricule) {
        return appUsersRepository.findByMatricule(matricule);
    }

    @Override
    public List<AppUsers> getAll() {
        return appUsersRepository.findAll();
    }

    @Override
    public AppUsers delete(Long id) {

        Optional<AppUsers> administrateur = appUsersRepository.findById(id);
        if (administrateur.isPresent()){
            appUsersRepository.deleteById(id);
            return administrateur.get();
        }
        return null;
    }

    @Override
    public AppUsers update(AppUsers appUsers, Long id) {
        if (appUsersRepository.findById(id).isPresent()){
            appUsers.setId(id);
            return appUsersRepository.save(appUsers);
        }
        return null;
    }
}
