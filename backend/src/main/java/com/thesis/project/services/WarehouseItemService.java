package com.thesis.project.services;

import com.thesis.project.dto.WarehouseItemDTO;
import com.thesis.project.model.WarIt;
import com.thesis.project.repositories.ItemRepository;
import com.thesis.project.repositories.UserRepository;
import com.thesis.project.repositories.WarehouseItemRepository;
import com.thesis.project.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseItemService {
    @Autowired
    WarehouseItemRepository warehouseItemRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    UserRepository userRepository;

    public List<WarIt> getWhItemsByWhId(Long whId) {
        return warehouseItemRepository.getWhItemsByWhId(whId);
    }

    public void save(WarehouseItemDTO warehouseItemDTO, Long id) {
        WarIt warIt = new WarIt();
        warIt.setPersonId(id);
        warIt.setItem(itemRepository.findProductById(warehouseItemDTO.getItemId()));
        warIt.setWarehouse(warehouseRepository.findByWhId(warehouseItemDTO.getWarehouseId()));
        warehouseItemRepository.save(warIt);
    }
}