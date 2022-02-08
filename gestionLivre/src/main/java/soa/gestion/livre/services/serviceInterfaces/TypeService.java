package soa.gestion.livre.services.serviceInterfaces;

import soa.gestion.livre.entities.Type;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);
    Type getTypeById(Long id);
    List<Type> getAllType();
    List<Type> getTypeByType(String type);
    Type deleteType(Long id);
    Type updateType(Type type, Long id);

}
