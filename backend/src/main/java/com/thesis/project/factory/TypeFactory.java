package com.thesis.project.factory;

import com.thesis.project.dto.TypeDTO;
import com.thesis.project.model.Type;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TypeFactory {
    public ArrayList<TypeDTO> typeToDTO(ArrayList<Type> types) {
        ArrayList<TypeDTO> typeDTOS = new ArrayList<>();
        types.stream().forEach((t -> typeDTOS.add(typeToDTO(t))));
        return typeDTOS;
    }

    public TypeDTO typeToDTO(Type type) {
        TypeDTO typetoDTO = new TypeDTO();
        typetoDTO.setId(type.getId());
        typetoDTO.setName(type.getName());

        return typetoDTO;
    }

    public Type typeFromDTO(TypeDTO typeDTO) {
        Type group = new Type();
        group.setId(typeDTO.getId());
        group.setName(typeDTO.getName());

        return group;
    }
}
