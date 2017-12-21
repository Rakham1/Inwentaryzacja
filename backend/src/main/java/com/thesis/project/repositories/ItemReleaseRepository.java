package com.thesis.project.repositories;

import com.thesis.project.model.ItemRelease;

import java.util.ArrayList;

public interface ItemReleaseRepository {
    ItemRelease findByIRelId (Long id);
    ArrayList<ItemRelease> findAllIRelsByUserId(Long personId);
    ArrayList<ItemRelease> getAllIRels();
    Long save(ItemRelease itemRelease);
    void update(ItemRelease itemRelease);
    void delete(ItemRelease itemRelease);
}
