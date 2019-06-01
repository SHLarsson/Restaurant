package com.example.Restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class InventoryController {

    private Inventory inventory = new Inventory();


    @RequestMapping(value = "/orders", method = GET)
    public List<InventoryItem> getInventoryItems(@RequestParam(value="searchString", defaultValue = "") String searchString) {


        return  inventory.getInventory(searchString);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public InventoryItem postInventoryItem(@RequestBody InventoryItem item) {

        inventory.addItem(item);
        return item;
    }

    @RequestMapping(value = "/orders/{id}", method = GET)
    public InventoryItem getInvetoryItem(@PathVariable("id") String itemId) {

        InventoryItem item = inventory.getInventoryItem(itemId);

        return item;
    }

    @RequestMapping(value= "/orders/{id}", method = DELETE)
    public InventoryItem deleteInventoryItem(@PathVariable("id") String itemId) {

        return inventory.deleteItem(itemId);
    }


    // vid patch kan vi inte mappa body mot en InventoryItem
    // utan måste mappa den mot en MAP (dictionary)
    // Patch -  @RequestBody Map<Object, Object> itemFields
    @RequestMapping(value = "/orders/{id}", method = PUT)
    public InventoryItem putInventoryItem(@PathVariable("id") String itemId,
                                          @RequestBody InventoryItem item) {

        inventory.replaceItemWithId(itemId, item);
        return item;
    }






}