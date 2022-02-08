package soa.gestion.livre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.modele.EmpruntLivre;
import soa.gestion.livre.services.serviceInterfaces.AppUsersService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AppUsersController {
    @Autowired
    private AppUsersService appUsersService;

    @PostMapping("/appusers/livre/emprunter")
    public Livre emprunterLivre(@RequestBody EmpruntLivre empruntLivre){
        return appUsersService.emprunterLivre(empruntLivre);
    }
    @PostMapping("/appusers/livre/emprunterbyappuser")
    public List<Livre> getLivrePreterByAppUsersNonRendu(@RequestBody Long idAppUser){
        return appUsersService.getLivrePreterByEtudiantNonRendu(idAppUser);
    }
    @PostMapping("/appusers/livre/arendre")
    public Livre rendreUnLivre(@RequestBody EmpruntLivre empruntLivre){
        return appUsersService.rendreUnLivre(empruntLivre);
    }
    @PostMapping("/appusers/livre/rappel")
    public void rappelerAppUsersNayantPasRenduLivre(@RequestBody EmpruntLivre empruntLivre){
        appUsersService.rappelerEtudiantNayantPasRenduLivre(empruntLivre);
    }
    @PostMapping("/appusers/livre/emprunter/nonrendu")
    List<EmpruntLivre> getTousLivresEmprunterNonRendu(){
        return appUsersService.getTousLivresEmprunterNonRendu();
    }
}
