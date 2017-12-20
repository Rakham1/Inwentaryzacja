package com.thesis.project.services;

import com.thesis.project.dto.WarehouseDTO;
import com.thesis.project.factory.WarehouseFactory;
import com.thesis.project.model.Warehouse;
import com.thesis.project.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseFactory warehouseFactory;

    public Warehouse findByWhId(Long id) {
        Warehouse warehouse = warehouseRepository.findByWhId(id);
        return warehouse;
    }

    public ArrayList<Warehouse> findAllWhs() {
        return warehouseRepository.findAllWhs();
    }

    public ArrayList<Warehouse> getWhsByFirmId(Long firmId) {
        return warehouseRepository.getWhsByFirmId(firmId);
    }

    @Transactional
    public void update(WarehouseDTO warehouseDTO) {
        warehouseRepository.update(warehouseFactory.whFromDTO(warehouseDTO));
    }

    @Transactional
    public void save(WarehouseDTO warehouseDTO) {
        warehouseRepository.save(warehouseFactory.whFromDTO(warehouseDTO));
    }

    @Transactional
    public void delete(Warehouse warehouse) {
        warehouseRepository.delete(warehouse);
    }
}
