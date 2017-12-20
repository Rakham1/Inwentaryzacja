package com.thesis.project.services;

import com.thesis.project.dto.InventoryDTO;
import com.thesis.project.factory.InventoryFactory;
import com.thesis.project.model.Inventory;
import com.thesis.project.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    InventoryFactory inventoryFactory;

    public Inventory findByInvId (Long id){
        return inventoryRepository.findByInvId(id);
    }
    public ArrayList<Inventory> findAllInvsByUserId(Long personId){
        return inventoryRepository.findAllInvsByUserId(personId);
    }
    public ArrayList<Inventory> getAllInvs(){
        return inventoryRepository.getAllInvs();
    }
    @Transactional
    public Long save(InventoryDTO inventoryDTO){
        return inventoryRepository.save(inventoryFactory.invFromDTO(inventoryDTO));
    }
    @Transactional
    public void update(InventoryDTO inventoryDTO){
        inventoryRepository.update(inventoryFactory.invFromDTO(inventoryDTO));
    }
    @Transactional
    public void delete(Inventory inventory){
        inventoryRepository.delete(inventory);
    }
}
