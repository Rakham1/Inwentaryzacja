package com.thesis.project.repositories;

import com.thesis.project.model.Item;

import java.util.ArrayList;

public interface ItemRepository {
    Item findProductById(Long id);

    Item findProductByName(String name);

    ArrayList<Item> findAllProducts();

    ArrayList<Item> search(String text);

    Item getItemByBarcode(String text);

    void update(Item item);

    Long save(Item item);

    void delete(Item item);
}
