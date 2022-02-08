package soa.gestion.livre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.livre.entities.EtatLivre;
import soa.gestion.livre.services.serviceInterfaces.EtatLivreService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EtatLivreController {
    @Autowired
    private EtatLivreService etatLivreService;

    @PostMapping("/etatlivres/save")
    public EtatLivre save(@RequestBody EtatLivre etatLivre ) {
        return etatLivreService.save(etatLivre);
    }
    @GetMapping("/etatlivres/{id}")
    public EtatLivre getEtaLivreById(@PathVariable Long id){
        return etatLivreService.getById(id);
    }

    @GetMapping("/etatlivres")
    public List<EtatLivre> getAllEtatLivre(){
        return etatLivreService.getAll();
    }

    @PostMapping("/etatlivres/delete")
    public EtatLivre deleteEtatLivre(@RequestBody Long id){
        return etatLivreService.delete(id);
    }

    @PostMapping("/etatlivres/update/{id}")
    public EtatLivre updateEtatLivre(@RequestBody EtatLivre etatLivre, @PathVariable Long id){
        return etatLivreService.update(etatLivre,id);
    }
}
