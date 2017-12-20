package com.thesis.project.repositories;

import com.thesis.project.model.Inventory;

import java.util.ArrayList;

public interface InventoryRepository {
    Inventory findByInvId (Long id);
    ArrayList<Inventory> findAllInvsByUserId(Long personId);
    ArrayList<Inventory> getAllInvs();
    Long save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Inventory inventory);
}
