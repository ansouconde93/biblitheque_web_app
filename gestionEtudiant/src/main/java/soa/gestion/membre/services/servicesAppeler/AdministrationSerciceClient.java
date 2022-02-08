package soa.gestion.membre.services.servicesAppeler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@FeignClient(name ="GESTION-ADMINISTRATION")
public interface AdministrationSerciceClient {
    @PostMapping("/membres/save/")
    int save(@RequestBody Map<Long, List<String>> listRolesName);
    @GetMapping("/membres/autorities/{idMembre}")
    Set<String> getMembreAutorities(@PathVariable Long idMembre);
}
