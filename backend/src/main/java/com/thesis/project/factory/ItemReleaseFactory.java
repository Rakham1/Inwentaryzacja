package com.thesis.project.factory;

import com.thesis.project.dto.ItemReleaseDTO;
import com.thesis.project.model.ItemRelease;
import com.thesis.project.repositories.ContractorRepository;
import com.thesis.project.repositories.UserRepository;
import com.thesis.project.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ItemReleaseFactory {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ContractorRepository contractorRepository;

    private ItemReleaseDTO relToDTO(ItemRelease itemRelease){
        ItemReleaseDTO itemReleaseDTO = new ItemReleaseDTO();
        itemReleaseDTO.setId(itemRelease.getId());
        itemReleaseDTO.setRelDocName(itemRelease.getRelDocName());
        itemReleaseDTO.setReleaseDate(itemRelease.getReleaseDate());
        itemReleaseDTO.setComment(itemRelease.getComment());
        itemReleaseDTO.setPersonId(itemRelease.getPerson().getId());
        itemReleaseDTO.setWarehouseId(itemRelease.getWarehouse().getId());
        itemReleaseDTO.setContractorId(itemRelease.getContractor().getId());
        return  itemReleaseDTO;
    }

    public ItemRelease relFromDTO(ItemReleaseDTO itemReleaseDTO){
        ItemRelease itemRelease = new ItemRelease();
        itemRelease.setId(itemReleaseDTO.getId());
        itemRelease.setRelDocName(itemReleaseDTO.getRelDocName());
        itemRelease.setReleaseDate(itemReleaseDTO.getReleaseDate());
        itemRelease.setComment(itemReleaseDTO.getComment());
        itemRelease.setWarehouse(warehouseRepository.findByWhId(itemReleaseDTO.getWarehouseId()));
        itemRelease.setPerson(userRepository.findById(itemReleaseDTO.getPersonId()));
        itemRelease.setContractor(contractorRepository.findByContractorId(itemReleaseDTO.getWarehouseId()));
        return itemRelease;
    }
    public ArrayList<ItemReleaseDTO> relToDTO(ArrayList<ItemRelease> itemReleases) {
        ArrayList<ItemReleaseDTO> itemReleaseDTOS = new ArrayList<>();
        itemReleases.stream().forEach((i -> itemReleaseDTOS.add(relToDTO(i))));
        return itemReleaseDTOS;
    }
}