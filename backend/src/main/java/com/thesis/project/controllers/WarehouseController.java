package com.thesis.project.controllers;

import com.thesis.project.dto.WarehouseDTO;
import com.thesis.project.factory.WarehouseFactory;
import com.thesis.project.model.Warehouse;
import com.thesis.project.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/whs")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseFactory warehouseFactory;

    @PostMapping("/addWh")
    public ResponseEntity<ArrayList<WarehouseDTO>> addWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
        warehouseService.save(warehouseDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allWhs")
    public ResponseEntity<ArrayList<WarehouseDTO>> getAll() throws NullPointerException {
        return new ResponseEntity<>(warehouseFactory.whToDTO(warehouseService.findAllWhs()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> loadUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(warehouseService.findByWhId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<WarehouseDTO> editItem(@RequestBody WarehouseDTO warehouseDTO, @PathVariable("id") Long id) {
        Warehouse warehouse = warehouseService.findByWhId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (warehouse != null) {
            warehouseDTO.setId(warehouse.getId());
            warehouseService.update(warehouseDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
        Warehouse warehouse = warehouseService.findByWhId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (warehouse != null) {
            warehouseService.delete(warehouse);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}