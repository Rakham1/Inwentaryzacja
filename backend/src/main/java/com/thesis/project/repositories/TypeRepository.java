package com.thesis.project.repositories;

import com.thesis.project.model.Type;

import java.util.ArrayList;

public interface TypeRepository {
    Type findTypeById(Long id);

    Type findTypeByName(String name);

    ArrayList<Type> findAllTypes();

    void update(Type type);

    void save(Type type);

    void delete(Type type);
}
