package soa.gestion.administration.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.administration.entities.Roles;
import soa.gestion.administration.modele.MembreRole;
import soa.gestion.administration.services.servicesInterface.MembreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin("*")
@RestController

public class MembreController {

    @Autowired
    private MembreService membreService;
    @PostMapping("/membres/save/")
    public int save(@RequestBody Map<Long,List<String>> listRolesName){
        for (Map.Entry<Long, List<String>> entry : listRolesName.entrySet()) {
            return membreService.save(entry.getKey(),entry.getValue());
        }
        return -1;
    }

    @GetMapping("/membres/roles/{idMembre}")
    public List<String> getRolesByMembre(@PathVariable Long idMembre){
        List<String> list = new ArrayList<>();
        membreService.getRolesByMembre(idMembre).forEach(roles -> {
            list.add(roles.getRole());
        });
        return list;
    }

    @GetMapping("/membres/autorities/{idMembre}")
    public Set<String> getMembreAutorities(@PathVariable Long idMembre){
        return membreService.getMembreAutorities(idMembre);
    }

    @PostMapping("/membres/delete")
    public int delete(@RequestBody Long id){
        return membreService.delete(id);
    }
    @PostMapping("/membres/suspendre")
    public int suspendreCeMembreAvecCeRole(@RequestBody MembreRole membreRole){
        return membreService.suspendreCeMembreAvecCeRole(membreRole);
    }
    @PostMapping("/membres/activer")
    public int activerMembreSuspendu(@RequestBody MembreRole membreRole){
        return membreService.activerMembreSuspendu(membreRole);
    }
}
