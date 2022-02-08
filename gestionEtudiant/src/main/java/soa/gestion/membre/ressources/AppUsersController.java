package soa.gestion.membre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.membre.entities.AppUsers;
import soa.gestion.membre.modele.Membre;
import soa.gestion.membre.modele.UserWithRoles;
import soa.gestion.membre.services.servicesInterface.AppUsersService;

import java.util.List;

@RestController
@CrossOrigin("*")

public class AppUsersController {

    @Autowired
    private AppUsersService appUsersService;

    @PostMapping("/appusers/save")
    public AppUsers save(@RequestBody UserWithRoles userWithRoles){
        return appUsersService.save(userWithRoles);
    }

    @GetMapping("/appusers/email/{email}")
    public AppUsers getByEmail(@PathVariable String email){
        return appUsersService.getByEmail(email);
    }
    @GetMapping("/appusers/telephone/{telephone}")
    public AppUsers getByTelephone(@PathVariable String telephone){
        return appUsersService.getByTelephone(telephone);
    }
    @GetMapping("/appusers/matricule/{matricule}")
    public AppUsers getByMatricule(@PathVariable String matricule){
        return appUsersService.getByMatricule(matricule);
    }
    @GetMapping("/appusers")
    public List<AppUsers> getAll(){
        return appUsersService.getAll();
    }

    @PostMapping("/appusers/delete")
    public AppUsers delete(@RequestBody Long id){
        return appUsersService.delete(id);
    }
    @PostMapping("/appusers/update/{id}")
    public AppUsers update(@RequestBody AppUsers appUsers, @PathVariable Long id){
        return appUsersService.update(appUsers,id);
    }

    @GetMapping("/appusers/username/{matricule}")
    public Membre getUserByUsername(@PathVariable String matricule){
        AppUsers appUsers = appUsersService.getByMatricule(matricule);
        if(appUsers!= null) {
            Membre membre = new Membre();
            membre.setId(appUsers.getId());
            membre.setUsername(appUsers.getMatricule());
            membre.setPassword(appUsers.getPassword());
            return membre;
        }
        return null;
    }
}
