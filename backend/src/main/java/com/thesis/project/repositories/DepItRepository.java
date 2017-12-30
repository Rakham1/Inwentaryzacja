package com.thesis.project.repositories;

import com.thesis.project.model.DepIt;

import java.util.ArrayList;

public interface DepItRepository {
    ArrayList<DepIt> getItemsByDepId(Long depotId);
    void save (DepIt depIt);
}
