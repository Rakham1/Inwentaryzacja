package com.thesis.project.repositories;

import com.thesis.project.model.Group;

import java.util.ArrayList;

public interface GroupRepository {
    Group findGroupById(long id);
    Group findGroupByName (String name);
    ArrayList<Group> findAllGroups();
    void update(Group group);
    void save(Group group);
    void delete(Group group);
}