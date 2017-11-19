package com.thesis.project.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.thesis.project.dto.FirmDTO;
import com.thesis.project.model.Person;
import com.thesis.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/users")
    public class PersonController {

        @Autowired
        private UserService userService;

        @GetMapping("/my")
        public Object getUsername(Authentication authentication) {
            return authentication;
        }

        @GetMapping("username/{username}")
        public ResponseEntity<Person> loadUserByUsername(@PathVariable("username") String username) throws JsonProcessingException {
            return new ResponseEntity<>(userService.findPersonByUsername(username), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Person> loadUserById(@PathVariable("id") Long id) throws JsonProcessingException {
            return new ResponseEntity<>(userService.findPersonById(id), HttpStatus.OK);

        }
    }
