package soa.gestion.livre.services.serviceInterfacesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soa.gestion.livre.Dao.TypeRepository;
import soa.gestion.livre.entities.Type;
import soa.gestion.livre.services.serviceInterfaces.TypeService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class TypeServiceImp implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getTypeById(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        if(type.isPresent())
            return type.get();
        return null;
    }

    @Override
    public List<Type> getAllType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> getTypeByType(String type) {
        return typeRepository.findByType(type);
    }

    @Override
    public Type deleteType(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        if (type.isPresent()){
            typeRepository.deleteById(id);
            return type.get();
        }
        return null;
    }

    @Override
    public Type updateType(Type type, Long id) {
        if(typeRepository.findById(id).isPresent()){
            type.setId(id);
            return typeRepository.save(type);
        }
        return null;
    }
}
