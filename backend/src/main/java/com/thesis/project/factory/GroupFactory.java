package com.thesis.project.factory;

import com.thesis.project.dto.GroupDTO;
import com.thesis.project.model.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GroupFactory {

    public ArrayList<GroupDTO> groupToDTO(ArrayList<Group> items) {
        ArrayList<GroupDTO> groupDTOS = new ArrayList<>();
        items.stream().forEach((g -> groupDTOS.add(groupToDTO(g))));
        return groupDTOS;
    }

    public GroupDTO groupToDTO(Group group) {
        GroupDTO grouptoDTO = new GroupDTO();
        grouptoDTO.setId(group.getId());
        grouptoDTO.setName(group.getName());
        grouptoDTO.setPermanent(group.isPermanent());

        return grouptoDTO;
    }

    public Group groupFromDTO(GroupDTO groupDTO) {
        Group group = new Group();
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        group.setPermanent(groupDTO.isPermanent());

        return group;
    }
}
