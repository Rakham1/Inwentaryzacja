package com.thesis.project.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.thesis.project.model.Person;
import com.thesis.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@RestController
@RequestMapping("/users")
public class PersonController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authorities")
    public ResponseEntity<String> welcomeUser() {
//            String login = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        return new ResponseEntity<>("{\"privilege\": \"" + authorities.toArray()[0].toString() + "\"}", HttpStatus.OK);
    }

    @GetMapping("/my")
    public Object getUsername(Authentication authentication) {
        return authentication;
    }


    @GetMapping("username/{username}")
    public ResponseEntity<Person> loadUserByUsername(@PathVariable("username") String username) throws JsonProcessingException {
        return new ResponseEntity<>(userService.findPersonByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> loadUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findPersonById(id), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        response.sendRedirect("/");
    }

}
