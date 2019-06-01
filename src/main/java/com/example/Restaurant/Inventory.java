package com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<InventoryItem> inventory;


    public Inventory() {
        this.inventory = new ArrayList<>();
        addMockData();
    }


    public List<InventoryItem> getInventory(String searchString) {

        if(searchString.equals(""))
            return inventory;


        ArrayList<InventoryItem> items = new ArrayList<>();
        for (InventoryItem item : inventory) {
            //if(item.getName().toLowerCase().contains(searchString.toLowerCase()))
                items.add(item);
        }

        return items;
    }

    public InventoryItem getInventoryItem(String id) {

        return findItemById(id);
    }

    public InventoryItem deleteItem(String id) {
        InventoryItem item = findItemById(id);

        inventory.remove(item);

        return item;
    }

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }


    public void replaceItemWithId(String id, InventoryItem newItem) {
        InventoryItem oldItem =  findItemById(id);

        inventory.remove(oldItem);

        newItem.setId(oldItem.getId());

        inventory.add(newItem);

    }

    private InventoryItem findItemById(String id) {
        for(InventoryItem item :  inventory) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }

    private void addMockData() {

        List<String> drinks1 = new ArrayList<String>();
        List<String> food1 = new ArrayList<String>();

        List<String> drinks2 = new ArrayList<String>();
        List<String> food2 = new ArrayList<String>();

        drinks1.add("cola");
        drinks1.add("fanta");

        drinks2.add("Water");
        drinks2.add("Cola");

        food1.add("Pizza");
        food1.add("Pasta");

        food2.add("Wok");
        food2.add("Taco");

        InventoryItem item1 = new InventoryItem("table1",drinks1 ,food1);
        InventoryItem item2 = new InventoryItem("table2",drinks2 ,food2);

        inventory.add(item1);
        inventory.add(item2);

    }

}