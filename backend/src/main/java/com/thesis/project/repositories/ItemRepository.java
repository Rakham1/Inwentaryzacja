package com.thesis.project.repositories;

import com.thesis.project.model.Item;

import java.util.ArrayList;

public interface ItemRepository{
    Item findProductById(long id);
    Item findProductByName (String name);
    ArrayList<Item> findAllProducts();
    ArrayList<Item> search(String text);
    Item getItemByBarcode(String text);
    void update(Item item);
    void save(Item item);
    void delete(Item item);
}
