package com.thesis.project.repositories;

import com.thesis.project.model.WarIt;

import java.util.ArrayList;
import java.util.List;

public interface WarehouseItemRepository {
    ArrayList<WarIt> getWhItemsByWhId(Long warehouseId);

    void save(WarIt warIt);
}