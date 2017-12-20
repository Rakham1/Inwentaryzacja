package com.thesis.project.factory;

import com.thesis.project.dto.RoleDTO;
import com.thesis.project.model.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RoleFactory {
    public ArrayList<RoleDTO> roleToDTO(ArrayList<Role> roles) {
        ArrayList<RoleDTO> roleDTOS = new ArrayList<>();
        roles.stream().forEach((r -> roleDTOS.add(roleToDTO(r))));
        return roleDTOS;
    }

    public RoleDTO roleToDTO(Role role) {
        RoleDTO roletoDTO = new RoleDTO();
        roletoDTO.setId(role.getId());
        roletoDTO.setName(role.getName());
        roletoDTO.setPrivilages(role.getPrivilages());
        return roletoDTO;
    }

    public Role roleFromDTO(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        role.setPrivilages(roleDTO.getPrivilages());
        return role;
    }
}