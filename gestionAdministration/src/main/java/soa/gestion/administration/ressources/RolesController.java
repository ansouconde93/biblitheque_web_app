package soa.gestion.administration.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.services.servicesInterface.RolesService;

import java.util.List;
@CrossOrigin("*")

@RestController
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @PostMapping("/roles/save/")
    public Roles save(@RequestBody Roles role){
        return rolesService.save(role);
    }

    @GetMapping("/roles/{id}")
    public Roles getById(@RequestParam Long id){
        return rolesService.getById(id);
    }

    @GetMapping("/roles")
    public List<Roles> getAll(){
        return rolesService.getAll();
    }
    @GetMapping("/roles/{role}")
    public Roles getByRole(@RequestParam String role){
        return rolesService.getByRole(role);
    }
    @GetMapping("/roles/autorisation/{id}")
    public List<Autorisations> getAutorisationsByRole(@RequestParam Long idRole){
        return rolesService.getAutorisationsByRole(idRole);
    }
    @PostMapping("/roles/delete")
    public Roles delete(@RequestBody Long id){
        return rolesService.delete(id);
    }
    @PostMapping("/roles/update/{id}")
    public Roles update(@RequestBody Roles role, @PathVariable Long id){
        return rolesService.update(role,id);
    }
}
