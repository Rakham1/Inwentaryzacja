package com.thesis.project.controllers;

import com.thesis.project.dto.RoleDTO;
import com.thesis.project.factory.RoleFactory;
import com.thesis.project.model.Role;
import com.thesis.project.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    RoleFactory roleFactory;

    @GetMapping("{id}")
    public ResponseEntity<Role> loadRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<>(roleService.findRoleById(id), HttpStatus.OK);
    }

    @GetMapping("/role/{name}")
    public ResponseEntity<Role> loadRoleByName(@PathVariable("name") String name){
        return new ResponseEntity<>(roleService.findRoleByName(name), HttpStatus.OK);
    }

    @GetMapping("/allRoles")
    public ResponseEntity<ArrayList<RoleDTO>> getAll(){
        return new ResponseEntity<>(roleFactory.roleToDTO(roleService.findAllRoles()), HttpStatus.OK);
    }
}
