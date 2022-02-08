package soa.gestion.livre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.livre.entities.Livre;
import soa.gestion.livre.services.serviceInterfaces.LivreService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LivreController {
    @Autowired
    private LivreService livreService;

    @PostMapping("/livres/save")
    public Livre saveLivre(@RequestBody Livre livre ) {
        return livreService.saveLivre(livre);
    }
    @GetMapping("/livres/{id}")
   public Livre getLivreById(@PathVariable Long id){
        return livreService.getLivreById(id);
    }

    @GetMapping("/livres/code/{code}")
   public List<Livre> getLivresByCode(@PathVariable String code){
        return livreService.getLivresByCode(code);
    }

    @GetMapping("/livres")
    public List<Livre> getAll(){
        return livreService.getAll();
    }

    @PostMapping("/livres/delete")
    public Livre deleteLivre(@RequestBody Long id){
        return livreService.deleteLivre(id);
    }

    @PostMapping("/livres/update/{id}")
    public Livre updateLivre(@RequestBody Livre livre, @PathVariable Long id){
        return livreService.updateLivre(livre,id);
    }
}
