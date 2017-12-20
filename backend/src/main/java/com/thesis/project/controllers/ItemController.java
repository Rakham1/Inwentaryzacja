package com.thesis.project.controllers;

import com.thesis.project.dto.ItemDTO;
import com.thesis.project.dto.ItemOutputDTO;
import com.thesis.project.dto.Search;
import com.thesis.project.dto.WarehouseItemDTO;
import com.thesis.project.factory.ItemFactory;
import com.thesis.project.model.Item;
import com.thesis.project.model.Person;
import com.thesis.project.model.Warehouse;
import com.thesis.project.repositories.UserRepository;
import com.thesis.project.services.ItemService;
import com.thesis.project.services.SearchService;
import com.thesis.project.services.WarehouseItemService;
import com.thesis.project.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    SearchService searchService;

    @Autowired
    ItemFactory itemFactory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WarehouseItemService warehouseItemService;

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody ItemDTO itemDTO) {
        Long i = itemService.save(itemDTO);
        return new ResponseEntity<>("{\"addedItemId\": \"" + i.toString() + "\"}", HttpStatus.OK);
    }

    @PostMapping("/addItemWh")
    public ResponseEntity<ArrayList<ItemDTO>> addItemToWh(@RequestBody WarehouseItemDTO warehouseItemDTO, Authentication authentication) {
        User user1 = (User) authentication.getPrincipal();
        Person user = userRepository.findByUsername(user1.getUsername());

        warehouseItemService.save(warehouseItemDTO, user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> loadItemById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @GetMapping("/item/{name}")
    public ResponseEntity<Item> loadItemByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(itemService.getItemByName(name), HttpStatus.OK);
    }

    @GetMapping("/item/{barcode}")
    public ResponseEntity<Item> loadItemByBarcode(@PathVariable("barcode") String barcode) {
        return new ResponseEntity<>(itemService.getItemByBarcode(barcode), HttpStatus.OK);
    }

    //    @GetMapping("/allItems")
//    public ResponseEntity<ArrayList<ItemOutputDTO>> getAll() throws NullPointerException {
//        return new ResponseEntity<>(itemFactory.itemtoDTO2(itemService.getAllItems()), HttpStatus.OK);
//    }
    @GetMapping("/allItems/{id}")
    public ResponseEntity<ArrayList<ItemOutputDTO>> getAllWh(@PathVariable("id") Long id) throws NullPointerException {
        Warehouse warehouse = warehouseService.findByWhId(id);
        return new ResponseEntity<>(
                itemFactory.itemtoDTO2(warehouseItemService.getWhItemsByWhId(warehouse.getId())), HttpStatus.OK);
    }

    @RequestMapping("/search")
    public ResponseEntity<Search> search(@RequestParam("key") String key) {
        Search search = new Search();
        if (key != null && !key.isEmpty()) {
            search.setItems(searchService.searchByItemName(key));
        }
        return new ResponseEntity<>(search, HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<ItemDTO> editItem(@RequestBody ItemDTO itemDTO, @PathVariable("id") Long id) {
        Item item = itemService.getItemById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (item != null) {
            itemDTO.setId(item.getId());
            itemService.update(itemDTO);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteItem(@PathVariable("id") Long id) {
        Item item = itemService.getItemById(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (item != null) {
            itemService.delete(item);
        } else
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(httpStatus);
    }
}