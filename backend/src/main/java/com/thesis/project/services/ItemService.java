package com.thesis.project.services;

import com.thesis.project.Factory.ItemFactory;
import com.thesis.project.dto.ItemDTO;
import com.thesis.project.dto.TypeDTO;
import com.thesis.project.model.Item;
import com.thesis.project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        itemRepository.save(itemFactory.itemFromDto(itDTO));
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

    public ArrayList<Item> getAllItems(){
        return itemRepository.findAllProducts();
    }
}