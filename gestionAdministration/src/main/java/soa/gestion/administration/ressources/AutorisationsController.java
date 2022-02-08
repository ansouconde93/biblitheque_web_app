package soa.gestion.administration.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.administration.entities.Autorisations;
import soa.gestion.administration.services.servicesInterface.AutorisationsService;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
public class AutorisationsController {

    @Autowired
    private AutorisationsService autorisationsService;

    @PostMapping("/autorisations/save")
    public Autorisations save(@RequestBody Autorisations autorisations){
        return autorisationsService.save(autorisations);
    }
    @GetMapping("/autorisations/{id}")
    public Autorisations getById(@RequestParam Long id){
        return autorisationsService.getById(id);
    }
    @GetMapping("/autorisations")
    public List<Autorisations> getAll(){
        return autorisationsService.getAll();
    }

    @GetMapping("/autorisations/all")
    public List<String> getAutorisationsNames(){
        List<String> list = new ArrayList<>();
        if (autorisationsService.getAll() != null){
            autorisationsService.getAll().forEach(autorisation -> {
                list.add(autorisation.getAutority());
            });
            return list;
        }
        return null;
    }

    @GetMapping("/autorisations/{autority}")
    public Autorisations getByAutority(@RequestParam String autority){
        return autorisationsService.getByAutority(autority);
    }
    @PostMapping("/autorisations/delete")
    public Autorisations delete(@RequestBody Long id){
        return autorisationsService.delete(id);
    }
    @PostMapping("/autorisations/update/{id}")
    public Autorisations update(@RequestBody Autorisations autorisation, @RequestParam Long id){
        return autorisationsService.update(autorisation,id);
    }
    @GetMapping("/autorisations/suspendre/{idAutorite}")
    public void suspendreAutority(@RequestParam Long idAutorite){
        autorisationsService.suspendreAutority(idAutorite);
    }
    @GetMapping("/autorisations/activer/{idAutorite}")
    public void activerAutorisationSuspendu(@RequestParam Long idAutorite){
        autorisationsService.activerAutorisationSuspendu(idAutorite);
    }
}
