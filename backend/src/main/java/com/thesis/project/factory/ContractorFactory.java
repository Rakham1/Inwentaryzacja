package com.thesis.project.factory;

import com.thesis.project.dto.ContractorDTO;
import com.thesis.project.model.Contractor;
import com.thesis.project.repositories.FirmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ContractorFactory {

    @Autowired
    FirmRepository firmRepository;

    public ArrayList<ContractorDTO> contractorToDTO(ArrayList<Contractor> contractors) {
        ArrayList<ContractorDTO> contractorDTOS = new ArrayList<>();
        contractors.stream().forEach((c -> contractorDTOS.add(contractorToDto(c))));
        return contractorDTOS;
    }

    public ContractorDTO contractorToDto(Contractor contractor) {
        ContractorDTO contractorDTO = new ContractorDTO();
        contractorDTO.setId(contractor.getId());
        contractorDTO.setFirmName(contractor.getFirmName());
        contractorDTO.setNip(contractor.getNip());
        contractorDTO.setStreet(contractor.getStreet());
        contractorDTO.setPostCode(contractor.getPostCode());
        contractorDTO.setCity(contractor.getCity());
        contractorDTO.setFirmId(contractor.getFirm().getFirmId());
        return contractorDTO;
    }

    public Contractor contractorFromDto(ContractorDTO contractorDTO) {
        Contractor contractor = new Contractor();
        contractor.setId(contractorDTO.getId());
        contractor.setFirmName(contractorDTO.getFirmName());
        contractor.setNip(contractorDTO.getNip());
        contractor.setStreet(contractorDTO.getStreet());
        contractor.setPostCode(contractorDTO.getPostCode());
        contractor.setCity(contractorDTO.getCity());
        contractor.setFirm(firmRepository.findByFirmId(contractorDTO.getFirmId()));
        return contractor;
    }
}
