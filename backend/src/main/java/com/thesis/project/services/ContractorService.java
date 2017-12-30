package com.thesis.project.services;

import com.thesis.project.dto.ContractorDTO;
import com.thesis.project.factory.ContractorFactory;
import com.thesis.project.model.Contractor;
import com.thesis.project.repositories.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ContractorService {
    @Autowired
    ContractorRepository contractorRepository;
    @Autowired
    ContractorFactory contractorFactory;

    public Contractor findByContractorId(Long id){
        return contractorRepository.findByContractorId(id);
    }

    public Contractor findContractorByStorageDepId(Long storageDepId){
        return contractorRepository.findContractorByStorageDepId(storageDepId);
    }

    public ArrayList<Contractor> getAllContractorsByFirmId(Long firmId) {
        return contractorRepository.getAllContractorsByFirmId(firmId);
    }

    public ArrayList<Contractor> getAllContractors(){
        return  contractorRepository.getAllContractors();
    }

    public void update(ContractorDTO contractorDTO){
        contractorRepository.update(contractorFactory.contractorFromDto(contractorDTO));
    }

    public void save(ContractorDTO contractorDTO){
        contractorRepository.save(contractorFactory.contractorFromDto(contractorDTO));
    }
}