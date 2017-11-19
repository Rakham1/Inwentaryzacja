package com.thesis.project.controllers;

import com.thesis.project.model.Firm;
import com.thesis.project.repositories.FirmRepository;
import com.thesis.project.services.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firms")
public class FirmController {

    @Autowired
    FirmService firmService;

    @GetMapping("/{id}")
    public ResponseEntity<Firm> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(firmService.findByFirmId(id), HttpStatus.OK);
    }
}
