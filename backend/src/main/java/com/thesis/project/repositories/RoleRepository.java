package com.thesis.project.repositories;

import com.thesis.project.model.Role;

import java.util.ArrayList;


public interface RoleRepository {
    Role findRoleById(Long id);

    Role findRoleByName(String name);

    ArrayList<Role> findAllRoles();
}
