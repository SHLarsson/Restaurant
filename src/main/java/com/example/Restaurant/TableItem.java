package com.example.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class TableItem {

    private String id;
    private boolean booked;

    public TableItem() {}

    public TableItem(String id, boolean booked) {
        this.id = id;
        this.booked = booked;
    }

    public String getId() {
        return id;
    }

    public boolean getBooked() {
        return booked;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}