package com.thesis.project.controllers;

import com.thesis.project.dto.ItemReleaseDTO;
import com.thesis.project.factory.ItemReleaseFactory;
import com.thesis.project.model.ItemRelease;
import com.thesis.project.services.ItemReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/releases")
public class ItemReleaseController {
    @Autowired
    ItemReleaseService itemReleaseService;
    @Autowired
    ItemReleaseFactory itemReleaseFactory;

    @PostMapping("/addRel")
    public ResponseEntity<String> addItemRelease(@RequestBody ItemReleaseDTO itemReleaseDTO) {
        Long i = itemReleaseService.save(itemReleaseDTO);
        return new ResponseEntity<>("{\"addedRelId\": \"" + i.toString() + "\"}", HttpStatus.OK);
    }

    @GetMapping("/allRels")
    public ResponseEntity<ArrayList<ItemReleaseDTO>> getAll() throws NullPointerException {
        return new ResponseEntity<>(itemReleaseFactory.relToDTO(itemReleaseService.getAllIRels()), HttpStatus.OK);
    }

    @GetMapping("/{id}/rels")
    public ResponseEntity<ArrayList<ItemReleaseDTO>> getRelsByUserId(@PathVariable("id") Long id){
        ArrayList<ItemReleaseDTO> itemReleaseDTOS = itemReleaseFactory.relToDTO(itemReleaseService.findAllIRelsByUserId(id));
        return new ResponseEntity<>(itemReleaseDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemRelease> loadItemReleaseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(itemReleaseService.findByIRelId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ItemReleaseDTO> editItem(@RequestBody ItemReleaseDTO itemReleaseDTO, @PathVariable("id") Long id) {
        ItemRelease itemRelease = itemReleaseService.findByIRelId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (itemRelease != null) {
            itemReleaseDTO.setId(itemRelease.getId());
            itemReleaseService.update(itemReleaseDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteInventory(@PathVariable("id") Long id) {
        ItemRelease itemRelease = itemReleaseService.findByIRelId(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (itemRelease != null) {
            itemReleaseService.delete(itemRelease);
        } else
            httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(httpStatus);
    }
}
