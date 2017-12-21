package com.thesis.project.repositories;

import com.thesis.project.model.RelIt;

import java.util.ArrayList;

public interface ReleaseItRepository {
    ArrayList<RelIt> getItemsByRelId(Long releaseId);
    void save (RelIt relIt);
}