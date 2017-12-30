package com.thesis.project.repositories;

import com.thesis.project.model.StorageDepot;

import java.util.ArrayList;

public interface StorageDepotRepository {
    StorageDepot findByDepId (Long id);
    ArrayList<StorageDepot> findAllDepotsByUserId(Long personId);
    ArrayList<StorageDepot> getAllDepots();
    Long save(StorageDepot storageDepot);
    void update(StorageDepot storageDepot);
    void delete(StorageDepot storageDepot);
}
