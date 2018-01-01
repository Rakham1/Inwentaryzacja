package com.thesis.project.services;

import com.thesis.project.dto.ReleaseItDTO;
import com.thesis.project.model.RelIt;
import com.thesis.project.repositories.ItemReleaseRepository;
import com.thesis.project.repositories.ItemRepository;
import com.thesis.project.repositories.ReleaseItRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReleaseItService {
    @Autowired
    ItemReleaseRepository itemReleaseRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ReleaseItRepository releaseItRepository;

    public ArrayList<RelIt> getItemsByRelId(Long releaseId){
        return releaseItRepository.getItemsByRelId(releaseId);
    }

    public void save (List<ReleaseItDTO> releaseItDTO){
        releaseItDTO.stream().forEach(item -> save(item));
    }

    public void save (ReleaseItDTO releaseItDTO){
        RelIt relIt = new RelIt();
        relIt.setAmount(releaseItDTO.getAmount());
        relIt.setItem(itemRepository.findProductById(releaseItDTO.getItemId()));
        relIt.setItemRelease(itemReleaseRepository.findByIRelId(releaseItDTO.getItemReleaseId()));
        releaseItRepository.save(relIt);
    }
}
