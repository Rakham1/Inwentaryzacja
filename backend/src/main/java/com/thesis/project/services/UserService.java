package com.thesis.project.services;

import com.thesis.project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.thesis.project.repositories.UserRepository;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;



    public Person findPersonByUsername(String username) throws UsernameNotFoundException{
        Person person = userRepository.findByUsername(username);
        if(person == null){
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return person;
    }

    public Person findPersonById(Long id) throws UsernameNotFoundException{
        Person person = userRepository.findById(id);
        if(person == null){
            throw new UsernameNotFoundException("User doesn't exists");
        }
        return person;
    }
}
