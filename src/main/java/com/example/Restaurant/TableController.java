package com.example.Restaurant;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class TableController {

    private Table table = new Table();


    @RequestMapping(value = "/bookings", method = GET)
    public List<TableItem> getTableItems(@RequestParam(value="searchString", defaultValue = "") String searchString) {


        return  table.getTables(searchString);
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.POST)
    public TableItem postTableItem(@RequestBody TableItem item) {

        table.addItem(item);
        return item;
    }

    @RequestMapping(value = "/bookings/{id}", method = GET)
    public TableItem getTableItem(@PathVariable("id") String itemId) {

        TableItem item = table.getTableItem(itemId);

        return item;
    }

    @RequestMapping(value= "/bookings/{id}", method = DELETE)
    public TableItem deleteTableItem(@PathVariable("id") String itemId) {

        return table.deleteItem(itemId);
    }


    // vid patch kan vi inte mappa body mot en InventoryItem
    // utan måste mappa den mot en MAP (dictionary)
    // Patch -  @RequestBody Map<Object, Object> itemFields
    @RequestMapping(value = "/bookings/{id}", method = PUT)
    public TableItem putTableItem(@PathVariable("id") String itemId,
                                          @RequestBody TableItem item) {

        table.replaceItemWithId(itemId, item);
        return item;
    }






}