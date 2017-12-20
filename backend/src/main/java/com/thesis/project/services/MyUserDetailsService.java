package com.thesis.project.services;

import com.thesis.project.model.Person;
import com.thesis.project.repositories.RoleRepository;
import com.thesis.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User nick doesnt exist");
        }
        return new User(user.getUsername(), user.getPassword(), true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getPrivilages())));
    }
}