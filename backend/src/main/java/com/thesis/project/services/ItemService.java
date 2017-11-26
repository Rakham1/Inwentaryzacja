package com.thesis.project.services;

import com.thesis.project.factory.ItemFactory;
import com.thesis.project.dto.ItemDTO;
import com.thesis.project.model.Item;
import com.thesis.project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemFactory itemFactory;

    @Transactional
    public void update(ItemDTO itDTO){
        itemRepository.update(itemFactory.itemFromDto(itDTO));
    }

    @Transactional
    public void save(ItemDTO itDTO){
        Item item1 = itemFactory.itemFromDto(itDTO);
        itemRepository.save(item1);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }

    public Item getItemById(long id){
        return itemRepository.findProductById(id);
    }

    public Item getItemByName(String name){
        return itemRepository.findProductByName(name);
    }

    public Item getItemByBarcode(String barcode){
        return itemRepository.getItemByBarcode(barcode);
    }

    public ArrayList<Item> getAllItems(){
        return itemRepository.findAllProducts();
    }
}