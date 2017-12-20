package com.thesis.project.services;

import com.thesis.project.dto.InventoryItemDTO;
import com.thesis.project.model.InvIte;
import com.thesis.project.repositories.InventoryItemRepository;
import com.thesis.project.repositories.InventoryRepository;
import com.thesis.project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventoryItemService {
    @Autowired
    InventoryItemRepository inventoryItemRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    public ArrayList<InvIte> getItemsByInvId(Long inventoryId){
        return inventoryItemRepository.getItemsByInvId(inventoryId);
    }

    public void save (InventoryItemDTO inventoryItemDTO){
        InvIte invIte = new InvIte();
        invIte.setItem(itemRepository.findProductById(inventoryItemDTO.getItemId()));
        invIte.setInventory(inventoryRepository.findByInvId(inventoryItemDTO.getInventoryId()));
        invIte.setAmount(inventoryItemDTO.getAmount());
        inventoryItemRepository.save(invIte);
    }
}
