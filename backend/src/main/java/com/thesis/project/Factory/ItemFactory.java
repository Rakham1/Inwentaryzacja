package com.thesis.project.Factory;

import com.thesis.project.dto.ItemDTO;
import com.thesis.project.model.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ItemFactory {

    public ArrayList<ItemDTO> itemToDTO(ArrayList<Item> items){
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        items.stream().forEach((i -> itemDTOS.add(itemToDTO(i))));
        return itemDTOS;
    }

    public ItemDTO itemToDTO(Item item){
        ItemDTO itemToDto = new ItemDTO();

        itemToDto.setId(item.getId());
        itemToDto.setItemName(item.getItemName());
        itemToDto.setDescription(item.getDescription());
        itemToDto.setStock(item.getStock());
        itemToDto.setUnit(item.getUnit());
        itemToDto.setBarcode(item.getBarcode());
//        itemToDto.setType(item.getType());
//        itemToDto.setGroup(item.getGroup());
        return itemToDto;
    }

    public Item itemFromDto(ItemDTO itemDTO){
        Item item = new Item();

        item.setId(itemDTO.getId());
        item.setItemName(itemDTO.getItemName());
        item.setDescription(itemDTO.getDescription());
        item.setStock(itemDTO.getStock());
        item.setUnit(itemDTO.getUnit());
        item.setBarcode(itemDTO.getBarcode());
//        item.setType(itemDTO.getType());
//        item.setGroup(itemDTO.getGroup());
        return item;
    }
}
