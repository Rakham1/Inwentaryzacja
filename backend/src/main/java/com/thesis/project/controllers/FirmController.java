package com.thesis.project.controllers;

import com.thesis.project.dto.ContractorDTO;
import com.thesis.project.dto.FirmDTO;
import com.thesis.project.dto.WarehouseDTO;
import com.thesis.project.factory.ContractorFactory;
import com.thesis.project.factory.FirmFactory;
import com.thesis.project.factory.WarehouseFactory;
import com.thesis.project.model.Contractor;
import com.thesis.project.model.Firm;
import com.thesis.project.model.Warehouse;
import com.thesis.project.services.ContractorService;
import com.thesis.project.services.FirmService;
import com.thesis.project.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/firms")
public class FirmController {

    @Autowired
    FirmService firmService;

    @Autowired
    WarehouseFactory warehouseFactory;

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    FirmFactory firmFactory;

    @Autowired
    ContractorService contractorService;

    @Autowired
    ContractorFactory contractorFactory;

    @GetMapping("/{id}")
    public ResponseEntity<Firm> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(firmService.findByFirmId(id), HttpStatus.OK);
    }

    @PostMapping("/addFirm")
    public ResponseEntity<ArrayList<FirmDTO>> addItem(@RequestBody FirmDTO firmDTO) {
        firmService.save(firmDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<FirmDTO> editItem(@RequestBody FirmDTO firmDTO, @PathVariable("id") Long id) {
        Firm firm = firmService.findByFirmId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (firm != null) {
            firmDTO.setId(firm.getFirmId());
            firmService.update(firmDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @GetMapping("/allFirms")
    public ResponseEntity<ArrayList<FirmDTO>> getAllFirms() {
        return new ResponseEntity<>(firmFactory.firmToDTO(firmService.getAllFirms()), HttpStatus.OK);
    }

    @GetMapping("/{id}/whs")
    public ResponseEntity<ArrayList<WarehouseDTO>> getWhsByFirm(@PathVariable("id") Long id){
        ArrayList<WarehouseDTO> warehouseDTOS = warehouseFactory.whToDTO(warehouseService.getWhsByFirmId(id));
        return new ResponseEntity<>(warehouseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}/contractors")
    public ResponseEntity<ArrayList<ContractorDTO>> getContrsByFirm(@PathVariable("id") Long id){
        ArrayList<ContractorDTO> contractorDTOS = contractorFactory.contractorToDTO(contractorService.getAllContractorsByFirmId(id));
        return new ResponseEntity<>(contractorDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}/user")
    public ResponseEntity<Firm> getFirmByUserId(@PathVariable("id") Long id){
        return new ResponseEntity<>(firmService.findFirmByUserId(id), HttpStatus.OK);
    }
}
