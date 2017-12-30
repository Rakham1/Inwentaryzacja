package com.thesis.project.services;

import com.thesis.project.dto.StorageDepotDTO;
import com.thesis.project.factory.StorageDepotFactory;
import com.thesis.project.model.StorageDepot;
import com.thesis.project.repositories.StorageDepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StorageDepotService {
    @Autowired
    StorageDepotRepository storageDepotRepository;
    @Autowired
    StorageDepotFactory storageDepotFactory;

    public StorageDepot findByDepId (Long id){
        return  storageDepotRepository.findByDepId(id);
    }
    public ArrayList<StorageDepot> findAllDeopotsByUserId(Long personId){
        return  storageDepotRepository.findAllDepotsByUserId(personId);
    }
    public ArrayList<StorageDepot> getAllDepots(){
        return  storageDepotRepository.getAllDepots();
    }
    public Long save(StorageDepotDTO storageDepotDTO){
        return storageDepotRepository.save(storageDepotFactory.depFromDTO(storageDepotDTO));
    }
    public void update(StorageDepotDTO storageDepotDTO){
        storageDepotRepository.update(storageDepotFactory.depFromDTO(storageDepotDTO));
    }
    public void delete(StorageDepot storageDepot){
        storageDepotRepository.delete(storageDepot);
    }
}
