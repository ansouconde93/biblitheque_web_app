package soa.gestion.livre.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.gestion.livre.entities.Type;
import soa.gestion.livre.services.serviceInterfaces.TypeService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @PostMapping("/types/save")
    public Type saveType(@RequestBody Type type ) {
        return typeService.saveType(type);
    }
    @GetMapping("/types/{id}")
    public Type getTypeById(@PathVariable Long id){
        return typeService.getTypeById(id);
    }

    @GetMapping("/types/{all}")
    public List<Type> getAllTypes(){
        return typeService.getAllType();
    }

    @GetMapping("/types/{type}")
    public List<Type> getTypeByType(@PathVariable String type){
        return typeService.getTypeByType(type);
    }

    @PostMapping("/types/delete")
    public Type deleteType(@RequestBody Long id){
        return typeService.deleteType(id);
    }

    @PostMapping("/types/update/{id}")
    public Type updateType(@RequestBody Type type, @PathVariable Long id){
        return typeService.updateType(type,id);
    }
}
