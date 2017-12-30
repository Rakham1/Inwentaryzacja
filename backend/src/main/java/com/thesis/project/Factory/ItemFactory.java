package com.thesis.project.factory;

import com.thesis.project.dto.*;
import com.thesis.project.model.*;
import com.thesis.project.repositories.*;
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

    @Autowired
    InventoryItemRepository inventoryItemRepository;

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

    private ItemOutputInventoryDTO itemtoDTO3(InvIte invIte) {
        ItemOutputInventoryDTO itemOutputInventoryDTO = new ItemOutputInventoryDTO();
        Item item = invIte.getItem();

        itemOutputInventoryDTO.setId(item.getId());
        itemOutputInventoryDTO.setItemName(item.getItemName());
        itemOutputInventoryDTO.setDescription(item.getDescription());
        itemOutputInventoryDTO.setStock(item.getStock());
        itemOutputInventoryDTO.setUnit(item.getUnit());
        itemOutputInventoryDTO.setInvItes(item.getInvItes());
        return itemOutputInventoryDTO;
    }

    public ArrayList<ItemOutputInventoryDTO> itemtoDTO3(List<InvIte> invItes) {
        ArrayList<ItemOutputInventoryDTO> itemOutputDTOS = new ArrayList<>();
        invItes.stream().forEach((i -> itemOutputDTOS.add(itemtoDTO3(i))));
        return itemOutputDTOS;
    }

    private ItemOutputReleaseDTO itemtoDTO4(RelIt relIt) {
        ItemOutputReleaseDTO itemOutputReleaseDTO = new ItemOutputReleaseDTO();
        Item item = relIt.getItem();

        itemOutputReleaseDTO.setId(item.getId());
        itemOutputReleaseDTO.setItemName(item.getItemName());
        itemOutputReleaseDTO.setDescription(item.getDescription());
        itemOutputReleaseDTO.setStock(item.getStock());
        itemOutputReleaseDTO.setUnit(item.getUnit());
        itemOutputReleaseDTO.setPrice(item.getPrice());
        itemOutputReleaseDTO.setRelIts(item.getRelIts());
        return itemOutputReleaseDTO;
    }

    public ArrayList<ItemOutputReleaseDTO> itemtoDTO4(List<RelIt> relIts) {
        ArrayList<ItemOutputReleaseDTO> itemOutputDTOS = new ArrayList<>();
        relIts.stream().forEach((i -> itemOutputDTOS.add(itemtoDTO4(i))));
        return itemOutputDTOS;
    }

    private ItemOutputDepotDTO itemtoDTO5(DepIt depIt) {
        ItemOutputDepotDTO itemOutputDepotDTO = new ItemOutputDepotDTO();
        Item item = depIt.getItem();

        itemOutputDepotDTO.setId(item.getId());
        itemOutputDepotDTO.setItemName(item.getItemName());
        itemOutputDepotDTO.setDescription(item.getDescription());
        itemOutputDepotDTO.setUnit(item.getUnit());
        itemOutputDepotDTO.setPrice(item.getPrice());
        itemOutputDepotDTO.setDepItSet(item.getDepIts());
        return itemOutputDepotDTO;
    }

    public ArrayList<ItemOutputDepotDTO> itemtoDTO5(List<DepIt> depIts) {
        ArrayList<ItemOutputDepotDTO> itemOutputDTOS = new ArrayList<>();
        depIts.stream().forEach((i -> itemOutputDTOS.add(itemtoDTO5(i))));
        return itemOutputDTOS;
    }
}