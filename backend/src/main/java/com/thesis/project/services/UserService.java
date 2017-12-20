package com.thesis.project.services;

import com.thesis.project.dto.PersonInputDTO;
import com.thesis.project.factory.PersonFactory;
import com.thesis.project.model.Person;
import com.thesis.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonFactory personFactory;

    public Person findPersonByUsername(String username) throws UsernameNotFoundException {
        Person person = userRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return person;
    }

    public Person findPersonById(Long id) throws UsernameNotFoundException {
        Person person = userRepository.findById(id);
        if (person == null) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return person;
    }

    public ArrayList<Person> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Transactional
    public void update(PersonInputDTO personInputDTO) {
        userRepository.update(personFactory.personFromDto(personInputDTO));
    }

    @Transactional
    public void save(PersonInputDTO personInputDTO) {
        Person person = personFactory.personFromDto(personInputDTO);
        userRepository.save(person);
    }

    @Transactional
    public void delete(Person person) {
        userRepository.delete(person);
    }
}
