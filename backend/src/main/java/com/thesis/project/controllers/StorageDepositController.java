package com.thesis.project.controllers;

import com.thesis.project.dto.StorageDepotDTO;
import com.thesis.project.factory.StorageDepotFactory;
import com.thesis.project.model.StorageDepot;
import com.thesis.project.services.StorageDepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/deps")
public class StorageDepositController {
    @Autowired
    StorageDepotService storageDepotService;
    @Autowired
    StorageDepotFactory storageDepotFactory;

    @PostMapping("/addDep")
    public ResponseEntity<String> addDepot(@RequestBody StorageDepotDTO storageDepotDTO) {
        Long i = storageDepotService.save(storageDepotDTO);
        return new ResponseEntity<>("{\"addedDepId\": \"" + i.toString() + "\"}", HttpStatus.OK);
    }

    @GetMapping("/allDeps")
    public ResponseEntity<ArrayList<StorageDepotDTO>> getAll() throws NullPointerException {
        return new ResponseEntity<>(storageDepotFactory.depToDTO(storageDepotService.getAllDepots()), HttpStatus.OK);
    }

    @GetMapping("/{id}/deps")
    public ResponseEntity<ArrayList<StorageDepotDTO>> getDepsByUserId(@PathVariable("id") Long id){
        ArrayList<StorageDepotDTO> storageDepotDTOS = storageDepotFactory.depToDTO(storageDepotService.findAllDeopotsByUserId(id));
        return new ResponseEntity<>(storageDepotDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StorageDepot> loadDepById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(storageDepotService.findByDepId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<StorageDepotDTO> editItem(@RequestBody StorageDepotDTO storageDepotDTO, @PathVariable("id") Long id) {
        StorageDepot storageDepot = storageDepotService.findByDepId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (storageDepot != null) {
            storageDepotDTO.setId(storageDepot.getId());
            storageDepotService.update(storageDepotDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") Long id) {
        StorageDepot storageDepot = storageDepotService.findByDepId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (storageDepot != null) {
            storageDepotService.delete(storageDepot);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}
