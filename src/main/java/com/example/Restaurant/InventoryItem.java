package com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class InventoryItem {

    private String id;
    private List<String> drinks;
    private List<String> food;

    public InventoryItem() {}

    public InventoryItem(String id, List<String> drinks, List<String> food) {
        this.id = id;
        this.drinks = drinks;
        this.food = food;
    }

    public String getId() {
        return id;
    }

    public List<String> getDrinks() {
        return drinks;
    }

    public List<String> getFood() {
        return food;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDrinks(List<String> drinks) {
        this.drinks = drinks;
    }

    public void setFood(List<String> food) {
        this.food = food;
    }
}