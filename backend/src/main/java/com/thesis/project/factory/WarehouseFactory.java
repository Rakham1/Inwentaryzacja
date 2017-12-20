package com.thesis.project.factory;

import com.thesis.project.dto.WarehouseDTO;
import com.thesis.project.model.Warehouse;
import com.thesis.project.repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class WarehouseFactory {
    @Autowired
    FirmRepository firmRepository;

    public ArrayList<WarehouseDTO> whToDTO(ArrayList<Warehouse> warehouses) {
        ArrayList<WarehouseDTO> warehouseDTOS = new ArrayList<>();
        warehouses.stream().forEach((w -> warehouseDTOS.add(whToDTO(w))));
        return warehouseDTOS;
    }

    public WarehouseDTO whToDTO(Warehouse warehouse) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setId(warehouse.getId());
        warehouseDTO.setName(warehouse.getName());
        warehouseDTO.setCity(warehouse.getCity());
        warehouseDTO.setPostCode(warehouse.getPostCode());
        warehouseDTO.setStreet(warehouse.getStreet());
        warehouseDTO.setFirmId(warehouse.getFirm().getFirmId());
        return warehouseDTO;
    }

    public Warehouse whFromDTO(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseDTO.getId());
        warehouse.setName(warehouseDTO.getName());
        warehouse.setCity(warehouseDTO.getCity());
        warehouse.setPostCode(warehouseDTO.getPostCode());
        warehouse.setStreet(warehouseDTO.getStreet());
        warehouse.setFirm(firmRepository.findByFirmId(warehouseDTO.getFirmId()));
        return warehouse;
    }
}
