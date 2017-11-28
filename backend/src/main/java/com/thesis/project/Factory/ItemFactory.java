package com.thesis.project.factory;

import com.thesis.project.dto.GroupDTO;
import com.thesis.project.dto.ItemDTO;
import com.thesis.project.dto.ItemOutputDTO;
import com.thesis.project.dto.TypeDTO;
import com.thesis.project.model.Item;
import com.thesis.project.repositories.GroupRepository;
import com.thesis.project.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ItemFactory {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    GroupRepository groupRepository;

    ItemOutputDTO itemOutputDTO;

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
        itemToDto.setTypeId(item.getType().getId());
        itemToDto.setGroupId(item.getGroup().getId());
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
        item.setType(typeRepository.findTypeById(itemDTO.getTypeId()));
        item.setGroup(groupRepository.findGroupById(itemDTO.getGroupId()));
        return item;
    }
}