package com.thesis.project.controllers;

import com.thesis.project.dto.PersonInputDTO;
import com.thesis.project.dto.PersonOutputDTO;
import com.thesis.project.factory.PersonFactory;
import com.thesis.project.model.Person;
import com.thesis.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private PersonFactory personFactory;

    @PostMapping("/addUser")
    public ResponseEntity<ArrayList<PersonInputDTO>> addPerson(@RequestBody PersonInputDTO personInputDTO){
        userService.save(personInputDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<ArrayList<PersonOutputDTO>> getAll() throws NullPointerException{
        return new ResponseEntity<>(personFactory.persontoDTO2(userService.findAllUsers()), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<PersonInputDTO> editItem(@RequestBody PersonInputDTO personInputDTO, @PathVariable("id") long id){
        Person person = userService.findPersonById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if(person != null){
            personInputDTO.setId(person.getId());
            userService.update(personInputDTO);
        }
        else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteItem(@PathVariable("id") long id){
        Person person = userService.findPersonById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if(person != null){
            userService.delete(person);
        }
        else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}
