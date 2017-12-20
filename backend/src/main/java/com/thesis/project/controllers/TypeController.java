package com.thesis.project.controllers;

import com.thesis.project.dto.TypeDTO;
import com.thesis.project.factory.TypeFactory;
import com.thesis.project.model.Type;
import com.thesis.project.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/types")
public class TypeController {
    @Autowired
    TypeFactory typeFactory;

    @Autowired
    TypeService typeService;

    @GetMapping("/{id}")
    public ResponseEntity<Type> loadTypeById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(typeService.findTypeById(id), HttpStatus.OK);
    }

    @GetMapping("/group/{name}")
    public ResponseEntity<Type> loadTypeById(@PathVariable("name") String name) {
        return new ResponseEntity<>(typeService.findTypeByName(name), HttpStatus.OK);
    }

    @GetMapping("/allTypes")
    public ResponseEntity<ArrayList<TypeDTO>> getAll() {
        return new ResponseEntity<>(typeFactory.typeToDTO(typeService.findAllTypes()), HttpStatus.OK);
    }

    @PostMapping("/addType")
    public ResponseEntity<ArrayList<TypeDTO>> addType(@RequestBody TypeDTO typeDTO) {
        typeService.save(typeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/edit")
    public ResponseEntity<TypeDTO> editType(@RequestBody TypeDTO typeDTO, @PathVariable("id") Long id) {
        Type type = typeService.findTypeById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (type != null) {
            typeDTO.setId(type.getId());
            typeService.update(typeDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteType(@PathVariable("id") Long id) {
        Type type = typeService.findTypeById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (type != null) {
            typeService.delete(type);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}
