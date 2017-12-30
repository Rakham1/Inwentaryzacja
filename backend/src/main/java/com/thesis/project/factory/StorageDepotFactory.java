package com.thesis.project.factory;

import com.thesis.project.dto.StorageDepotDTO;
import com.thesis.project.model.StorageDepot;
import com.thesis.project.repositories.ContractorRepository;
import com.thesis.project.repositories.UserRepository;
import com.thesis.project.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StorageDepotFactory {
    @Autowired
    ContractorRepository contractorRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    UserRepository userRepository;
    private StorageDepotDTO depToDTO(StorageDepot storageDepot){
        StorageDepotDTO storageDepotDTO = new StorageDepotDTO();
        storageDepotDTO.setId(storageDepot.getId());
        storageDepotDTO.setDepotDate(storageDepot.getDepotDate());
        storageDepotDTO.setComment(storageDepot.getComment());
        storageDepotDTO.setContractorId(storageDepot.getContractor().getId());
        storageDepotDTO.setInvoiceName(storageDepot.getInvoiceName());
        storageDepotDTO.setWarehouseId(storageDepot.getWarehouse().getId());
        storageDepotDTO.setPersonId(storageDepot.getPerson().getId());
        return  storageDepotDTO;
    }

    public StorageDepot depFromDTO(StorageDepotDTO storageDepotDTO){
        StorageDepot storageDepot = new StorageDepot();
        storageDepot.setId(storageDepotDTO.getId());
        storageDepot.setDepotDate(storageDepotDTO.getDepotDate());
        storageDepot.setComment(storageDepotDTO.getComment());
        storageDepot.setContractor(contractorRepository.findByContractorId(storageDepotDTO.getContractorId()));
        storageDepot.setWarehouse(warehouseRepository.findByWhId(storageDepotDTO.getWarehouseId()));
        storageDepot.setPerson(userRepository.findById(storageDepotDTO.getPersonId()));
        storageDepot.setInvoiceName(storageDepotDTO.getInvoiceName());
        return storageDepot;
    }
    public ArrayList<StorageDepotDTO> depToDTO(ArrayList<StorageDepot> storageDepots) {
        ArrayList<StorageDepotDTO> storageDepotDTOS = new ArrayList<>();
        storageDepots.stream().forEach((i -> storageDepotDTOS.add(depToDTO(i))));
        return storageDepotDTOS;
    }
}