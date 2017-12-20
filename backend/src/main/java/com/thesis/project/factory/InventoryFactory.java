package com.thesis.project.factory;

import com.thesis.project.dto.InventoryDTO;
import com.thesis.project.model.Inventory;
import com.thesis.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventoryFactory {
    @Autowired
    UserRepository userRepository;

    public InventoryDTO invToDTO(Inventory inventory){
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setInventoryNumber(inventory.getInventoryNumber());
        inventoryDTO.setCommitteeSquad(inventory.getCommitteeSquad());
        inventoryDTO.setComment(inventory.getComment());
        inventoryDTO.setPersonId(inventory.getUser().getId());
        return inventoryDTO;
    }

    public Inventory invFromDTO(InventoryDTO inventoryDTO){
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDTO.getId());
        inventory.setInventoryNumber(inventoryDTO.getInventoryNumber());
        inventory.setCommitteeSquad(inventoryDTO.getCommitteeSquad());
        inventory.setComment(inventoryDTO.getComment());
        inventory.setUser(userRepository.findById(inventoryDTO.getPersonId()));
        return inventory;
    }
    public ArrayList<InventoryDTO> invToDTO(ArrayList<Inventory> inventories) {
        ArrayList<InventoryDTO> inventoryDTOS = new ArrayList<>();
        inventories.stream().forEach((i -> inventoryDTOS.add(invToDTO(i))));
        return inventoryDTOS;
    }
}