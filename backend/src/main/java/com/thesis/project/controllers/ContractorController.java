package com.thesis.project.controllers;

import com.thesis.project.dto.ContractorDTO;
import com.thesis.project.factory.ContractorFactory;
import com.thesis.project.model.Contractor;
import com.thesis.project.services.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/contractor")
public class ContractorController {
    @Autowired
    ContractorService contractorService;
    @Autowired
    ContractorFactory contractorFactory;

    @GetMapping("/{id}")
    public ResponseEntity<Contractor> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(contractorService.findByContractorId(id), HttpStatus.OK);
    }

    @PostMapping("/addContractor")
    public ResponseEntity<ArrayList<ContractorDTO>> addContractor(@RequestBody ContractorDTO contractorDTO) {
        contractorService.save(contractorDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ContractorDTO> editContractor(@RequestBody ContractorDTO contractorDTO, @PathVariable("id") Long id) {
        Contractor contractor = contractorService.findByContractorId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (contractor != null) {
            contractorDTO.setId(contractor.getId());
            contractorService.update(contractorDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(httpStatus);
    }

    @GetMapping("/allContractors")
    public ResponseEntity<ArrayList<ContractorDTO>> getAllContractors() {
        return new ResponseEntity<>(contractorFactory.contractorToDTO(contractorService.getAllContractors()), HttpStatus.OK);
    }

    @GetMapping("/{id}/storage")
    public ResponseEntity<Contractor> getFirmByStorageId(@PathVariable("id") Long id){
        return new ResponseEntity<>(contractorService.findContractorByStorageDepId(id), HttpStatus.OK);
    }
}