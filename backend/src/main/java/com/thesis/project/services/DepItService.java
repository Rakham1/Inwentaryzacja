package com.thesis.project.services;

import com.thesis.project.dto.DepItDTO;
import com.thesis.project.factory.StorageDepotFactory;
import com.thesis.project.model.DepIt;
import com.thesis.project.repositories.DepItRepository;
import com.thesis.project.repositories.ItemRepository;
import com.thesis.project.repositories.StorageDepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepItService {
    @Autowired
    StorageDepotRepository storageDepotRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    DepItRepository depItRepository;

    public ArrayList<DepIt> getItemsByDepId(Long depotId){
        return depItRepository.getItemsByDepId(depotId);
    }

    public void save (List<DepItDTO> depItDTO){
        depItDTO.stream().forEach(item -> save(item));
    }

    public void save (DepItDTO depItDTO){
        DepIt depIt = new DepIt();
        depIt.setAmount(depItDTO.getAmount());
        depIt.setItem(itemRepository.findProductById(depItDTO.getItemId()));
        depIt.setStorageDepot(storageDepotRepository.findByDepId(depItDTO.getDepotId()));
        depItRepository.save(depIt);
    }
}
