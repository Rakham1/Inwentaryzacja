package com.thesis.project.services;

import com.thesis.project.model.Role;
import com.thesis.project.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findRoleById(Long id){
        return roleRepository.findRoleById(id);
    }

    public Role findRoleByName(String name){
        return roleRepository.findRoleByName(name);
    }

    public ArrayList<Role> findAllRoles(){
        return roleRepository.findAllRoles();
    }
}
