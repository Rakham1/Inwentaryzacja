package com.thesis.project.factory;

import com.thesis.project.dto.InventoryDTO;
import com.thesis.project.model.Inventory;
import com.thesis.project.repositories.UserRepository;
import com.thesis.project.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class InventoryFactory {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public InventoryDTO invToDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setInventoryNumber(inventory.getInventoryNumber());
        inventoryDTO.setCommitteeSquad(inventory.getCommitteeSquad());
        inventoryDTO.setComment(inventory.getComment());
        inventoryDTO.setPersonId(inventory.getUser().getId());
        inventoryDTO.setWarehouseId(inventory.getWarehouse().getId());
        inventoryDTO.setInvDate(inventory.getInvDate());
        return inventoryDTO;
    }

    public Inventory invFromDTO(InventoryDTO inventoryDTO){
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDTO.getId());
        inventory.setInventoryNumber(inventoryDTO.getInventoryNumber());
        inventory.setCommitteeSquad(inventoryDTO.getCommitteeSquad());
        inventory.setComment(inventoryDTO.getComment());
        inventory.setUser(userRepository.findById(inventoryDTO.getPersonId()));
        inventory.setWarehouse(warehouseRepository.findByWhId(inventoryDTO.getWarehouseId()));
        inventory.setInvDate(inventoryDTO.getInvDate());
        return inventory;
    }
    public ArrayList<InventoryDTO> invToDTO(ArrayList<Inventory> inventories) {
        ArrayList<InventoryDTO> inventoryDTOS = new ArrayList<>();
        inventories.stream().forEach((i -> inventoryDTOS.add(invToDTO(i))));
        return inventoryDTOS;
    }
}