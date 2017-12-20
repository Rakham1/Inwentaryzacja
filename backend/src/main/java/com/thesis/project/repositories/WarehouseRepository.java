package com.thesis.project.repositories;

import com.thesis.project.model.Warehouse;

import java.util.ArrayList;

public interface WarehouseRepository {
    Warehouse findByWhId(Long id);

    ArrayList<Warehouse> findAllWhs();

    ArrayList<Warehouse> getWhsByFirmId(Long firmId);

    void update(Warehouse warehouse);

    void save(Warehouse warehouse);

    void delete(Warehouse warehouse);
}