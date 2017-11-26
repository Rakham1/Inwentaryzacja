package com.thesis.project.controllers;

import com.thesis.project.factory.GroupFactory;
import com.thesis.project.dto.GroupDTO;
import com.thesis.project.model.Group;
import com.thesis.project.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    GroupFactory groupFactory;

    @Autowired
    GroupService groupService;

    @GetMapping("/{id}")
    public ResponseEntity<Group> loadGroupById(@PathVariable("id") long id){
        return new ResponseEntity<>(groupService.findGroupById(id), HttpStatus.OK);
    }

    @GetMapping("/group/{name}")
    public ResponseEntity<Group> loadGroupById(@PathVariable("name") String name){
        return new ResponseEntity<>(groupService.findGroupByName(name), HttpStatus.OK);
    }

    @GetMapping("/allGroups")
    public ResponseEntity<ArrayList<GroupDTO>> getAll(){
        return new ResponseEntity<>(groupFactory.groupToDTO(groupService.findAllGroups()), HttpStatus.OK);
    }

    @PostMapping("/addGroup")
    public ResponseEntity<ArrayList<GroupDTO>> addGroup(@RequestBody GroupDTO groupDTO){
        groupService.save(groupDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/edit")
    public ResponseEntity<GroupDTO> editGroup(@RequestBody GroupDTO groupDTO, @PathVariable("id") long id){
        Group group = groupService.findGroupById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if(group != null){
            groupDTO.setId(group.getId());
            groupService.update(groupDTO);
        }
        else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteGroup(@PathVariable("id") long id){
        Group group = groupService.findGroupById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if(group != null){
            groupService.delete(group);
        }
        else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}
