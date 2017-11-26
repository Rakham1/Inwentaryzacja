package com.thesis.project.services;

import com.thesis.project.factory.GroupFactory;
import com.thesis.project.dto.GroupDTO;
import com.thesis.project.model.Group;
import com.thesis.project.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    GroupFactory groupFactory;

    public Group findGroupById(long id){
        return groupRepository.findGroupById(id);
    }

    public Group findGroupByName (String name){
        return groupRepository.findGroupByName(name);
    }

    public ArrayList<Group> findAllGroups(){
        return groupRepository.findAllGroups();
    }

    @Transactional
    public void update(GroupDTO groupDTO){
        groupRepository.update(groupFactory.groupFromDTO(groupDTO));
    }

    @Transactional
    public void save(GroupDTO groupDTO){
        groupRepository.save(groupFactory.groupFromDTO(groupDTO));
    }

    public void delete(Group group){
        groupRepository.delete(group);
    }
}
