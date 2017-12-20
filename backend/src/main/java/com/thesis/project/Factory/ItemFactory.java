package com.thesis.project.factory;

import com.thesis.project.dto.ItemDTO;
import com.thesis.project.dto.ItemOutputDTO;
import com.thesis.project.model.Item;
import com.thesis.project.model.WarIt;
import com.thesis.project.repositories.GroupRepository;
import com.thesis.project.repositories.ItemRepository;
import com.thesis.project.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemFactory {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    ItemRepository itemRepository;

    public ArrayList<ItemDTO> itemToDTO(ArrayList<Item> items) {
        ArrayList<ItemDTO> itemDTOS = new ArrayList<>();
        items.stream().forEach((i -> itemDTOS.add(itemToDTO(i))));
        return itemDTOS;
    }

    public ItemDTO itemToDTO(Item item) {
        ItemDTO itemToDto = new ItemDTO();

        itemToDto.setId(item.getId());
        itemToDto.setItemName(item.getItemName());
        itemToDto.setDescription(item.getDescription());
        itemToDto.setStock(item.getStock());
        itemToDto.setUnit(item.getUnit());
        itemToDto.setBarcode(item.getBarcode());
        itemToDto.setPrice(item.getPrice());
        itemToDto.setNotes(item.getNotes());
        itemToDto.setTypeId(item.getType().getId());
        itemToDto.setGroupId(item.getGroup().getId());
        return itemToDto;
    }

    public Item itemFromDto(ItemDTO itemDTO) {
        Item item = new Item();

        item.setId(itemDTO.getId());
        item.setItemName(itemDTO.getItemName());
        item.setDescription(itemDTO.getDescription());
        item.setStock(itemDTO.getStock());
        item.setUnit(itemDTO.getUnit());
        item.setBarcode(itemDTO.getBarcode());
        item.setPrice(itemDTO.getPrice());
        item.setNotes(itemDTO.getNotes());
        item.setType(typeRepository.findTypeById(itemDTO.getTypeId()));
        item.setGroup(groupRepository.findGroupById(itemDTO.getGroupId()));
        return item;
    }

    private ItemOutputDTO itemtoDTO2(WarIt warIt) {
        ItemOutputDTO itemOutputDTO = new ItemOutputDTO();
        Item item = warIt.getItem();

        itemOutputDTO.setId(item.getId());
        itemOutputDTO.setItemName(item.getItemName());
        itemOutputDTO.setDescription(item.getDescription());
        itemOutputDTO.setStock(item.getStock());
        itemOutputDTO.setUnit(item.getUnit());
        itemOutputDTO.setBarcode(item.getBarcode());
        itemOutputDTO.setPrice(item.getPrice());
        itemOutputDTO.setNotes(item.getNotes());
        itemOutputDTO.setTypeName(item.getType().getName());
        itemOutputDTO.setGroupName(item.getGroup().getName());
        return itemOutputDTO;
    }

    public ArrayList<ItemOutputDTO> itemtoDTO2(List<WarIt> warIts) {
        ArrayList<ItemOutputDTO> itemOutputDTOS = new ArrayList<>();
        warIts.stream().forEach((i -> itemOutputDTOS.add(itemtoDTO2(i))));
        return itemOutputDTOS;
    }

}