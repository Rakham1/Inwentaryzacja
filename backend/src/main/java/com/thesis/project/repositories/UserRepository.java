package com.thesis.project.repositories;

import com.thesis.project.model.Person;

import java.util.ArrayList;


public interface UserRepository {
    Person findByUsername(String username);

    Person findById(Long id);

    ArrayList<Person> findAllUsers();

    void update(Person person);

    void save(Person person);

    void delete(Person person);
}