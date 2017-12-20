package com.thesis.project.controllers;

import com.thesis.project.dto.InventoryDTO;
import com.thesis.project.factory.InventoryFactory;
import com.thesis.project.model.Inventory;
import com.thesis.project.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/invs")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @Autowired
    InventoryFactory inventoryFactory;

    @PostMapping("/addInv")
    public ResponseEntity<String> addInventory(@RequestBody InventoryDTO inventoryDTO) {
        Long i = inventoryService.save(inventoryDTO);
        return new ResponseEntity<>("{\"addedInvId\": \"" + i.toString() + "\"}",HttpStatus.OK);
    }

    @GetMapping("/allInvs")
    public ResponseEntity<ArrayList<InventoryDTO>> getAll() throws NullPointerException {
        return new ResponseEntity<>(inventoryFactory.invToDTO(inventoryService.getAllInvs()), HttpStatus.OK);
    }

    @GetMapping("/{id}/invs")
    public ResponseEntity<ArrayList<InventoryDTO>> getInvsByUserId(@PathVariable("id") Long id){
        ArrayList<InventoryDTO> inventoryDTOS = inventoryFactory.invToDTO(inventoryService.findAllInvsByUserId(id));
        return new ResponseEntity<>(inventoryDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> loadInventoryById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(inventoryService.findByInvId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<InventoryDTO> editItem(@RequestBody InventoryDTO inventoryDTO, @PathVariable("id") Long id) {
        Inventory inventory = inventoryService.findByInvId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (inventory != null) {
            inventoryDTO.setId(inventory.getId());
            inventoryService.update(inventoryDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") Long id) {
        Inventory inventory = inventoryService.findByInvId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (inventory != null) {
            inventoryService.delete(inventory);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}