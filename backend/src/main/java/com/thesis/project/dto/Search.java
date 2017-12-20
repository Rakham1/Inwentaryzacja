package com.thesis.project.dto;

import java.util.ArrayList;

public class Search {
    private ArrayList<ItemDTO> items;

    public Search() {
        super();
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemDTO> items) {
        this.items = items;
    }
}
