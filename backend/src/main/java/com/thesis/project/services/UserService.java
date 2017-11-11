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
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Person user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User nick doesnt exist");
        }
        return new User(user.getNickname(),user.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
    }
}
