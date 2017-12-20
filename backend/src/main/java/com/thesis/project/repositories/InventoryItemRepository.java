package com.thesis.project.repositories;

import com.thesis.project.model.InvIte;

import java.util.ArrayList;

public interface InventoryItemRepository {
    ArrayList<InvIte> getItemsByInvId(Long inventoryId);

    void save (InvIte invIte);
}
