package com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<TableItem> tables;


    public Table() {
        this.tables = new ArrayList<>();
        addMockData();
    }


    public List<TableItem> getTables(String searchString) {

        if(searchString.equals(""))
            return tables;


        ArrayList<TableItem> items = new ArrayList<>();
        for (TableItem item : tables) {
            //if(item.getName().toLowerCase().contains(searchString.toLowerCase()))
            items.add(item);
        }

        return items;
    }

    public TableItem getTableItem(String id) {

        return findItemById(id);
    }

    public TableItem deleteItem(String id) {
        TableItem item = findItemById(id);

        tables.remove(item);

        return item;
    }

    public void addItem(TableItem item) {
        tables.add(item);
    }


    public void replaceItemWithId(String id, TableItem newItem) {
        TableItem oldItem =  findItemById(id);

        tables.remove(oldItem);

        newItem.setId(oldItem.getId());

        tables.add(newItem);

    }

    private TableItem findItemById(String id) {
        for(TableItem item :  tables) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }

    private void addMockData() {

        TableItem item1 = new TableItem("table1",true);
        TableItem item2 = new TableItem("table2",true);

        tables.add(item1);
        tables.add(item2);

    }

}