package soa.gestion.livre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.livre.entities.Auteurs;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.services.serviceInterfaces.AuteursService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AuteursController {
    @Autowired
    private AuteursService auteursService;

    @PostMapping("/auteurs/save")
    public Auteurs save(@RequestBody Auteurs auteur ) {
        return auteursService.save(auteur);
    }
    @GetMapping("/auteurs/{id}")
    public Auteurs getAuteurById(@PathVariable Long id){
        return auteursService.getById(id);
    }

    @GetMapping("/auteurs/livre/{auteurId}")
    public List<Livre> getAllLivreByAuteurs(@PathVariable Long auteurId){
        return auteursService.getAllLivreByAuteurs(auteurId);
    }

    @PostMapping("/auteurs/delete")
    public Auteurs deleteAuteur(@RequestBody Long id){
        return auteursService.delete(id);
    }

    @PostMapping("/auteurs/update/{id}")
    public Auteurs updateEtatLivre(@RequestBody Auteurs auteur, @PathVariable Long id){
        return auteursService.update(auteur,id);
    }

}
