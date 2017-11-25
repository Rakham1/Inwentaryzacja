package com.thesis.project.services;

import com.thesis.project.Factory.ItemFactory;
import com.thesis.project.dto.ItemDTO;
import com.thesis.project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemFactory itemFactory;

    public ArrayList<ItemDTO> searchByItemName(String name){
        ArrayList<ItemDTO> searchResult = itemFactory.itemToDTO(itemRepository.search(name));
        return  searchResult;
    }
}
