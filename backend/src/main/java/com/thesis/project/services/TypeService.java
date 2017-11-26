package com.thesis.project.services;

import com.thesis.project.dto.TypeDTO;
import com.thesis.project.factory.TypeFactory;
import com.thesis.project.model.Type;
import com.thesis.project.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    TypeFactory typeFactory;

    public Type findTypeById(long id){
        return typeRepository.findTypeById(id);
    }

    public Type findTypeByName (String name){
        return typeRepository.findTypeByName(name);
    }

    public ArrayList<Type> findAllTypes(){
        return typeRepository.findAllTypes();
    }

    @Transactional
    public void update(TypeDTO typeDTO){
        typeRepository.update(typeFactory.typeFromDTO(typeDTO));
    }

    @Transactional
    public void save(TypeDTO typeDTO){
        typeRepository.save(typeFactory.typeFromDTO(typeDTO));
    }

    public void delete(Type type){
        typeRepository.delete(type);
    }
}
