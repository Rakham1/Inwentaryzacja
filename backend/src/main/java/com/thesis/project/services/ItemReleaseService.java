package com.thesis.project.services;

import com.thesis.project.dto.ItemReleaseDTO;
import com.thesis.project.factory.ItemReleaseFactory;
import com.thesis.project.model.ItemRelease;
import com.thesis.project.repositories.ItemReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemReleaseService {
    @Autowired
    ItemReleaseRepository itemReleaseRepository;
    @Autowired
    ItemReleaseFactory itemReleaseFactory;

    public ItemRelease findByIRelId (Long id){
        return itemReleaseRepository.findByIRelId(id);
    }
    public ArrayList<ItemRelease> findAllIRelsByUserId(Long personId){
        return itemReleaseRepository.findAllIRelsByUserId(personId);
    }
    public ArrayList<ItemRelease> getAllIRels(){
        return itemReleaseRepository.getAllIRels();
    }

    public Long save(ItemReleaseDTO itemReleaseDTO){
        return itemReleaseRepository.save(itemReleaseFactory.relFromDTO(itemReleaseDTO));
    }
    public void update(ItemReleaseDTO itemReleaseDTO){
        itemReleaseRepository.update(itemReleaseFactory.relFromDTO(itemReleaseDTO));
    }
    public void delete(ItemRelease itemRelease){
        itemReleaseRepository.delete(itemRelease);
    }
}
