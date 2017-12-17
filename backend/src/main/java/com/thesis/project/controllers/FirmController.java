package com.thesis.project.controllers;

import com.thesis.project.dto.FirmDTO;
import com.thesis.project.model.Firm;
import com.thesis.project.repositories.FirmRepository;
import com.thesis.project.services.FirmService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Firm> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(firmService.findByFirmId(id), HttpStatus.OK);
    }

    @PostMapping("/addFirm")
    public ResponseEntity<ArrayList<FirmDTO>> addItem(@RequestBody FirmDTO firmDTO){
        firmService.save(firmDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<FirmDTO> editItem(@RequestBody FirmDTO firmDTO, @PathVariable("id") long id){
        Firm firm = firmService.findByFirmId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if(firm != null){
            firmDTO.setId(firm.getFirmId());
            firmService.update(firmDTO);
        }
        else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}
