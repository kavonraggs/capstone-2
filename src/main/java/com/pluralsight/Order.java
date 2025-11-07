package com.pluralsight;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime orderTime;
    private List<Food> items;



    public void addItem(Food item){
        items.add(item);
    }

    public String getReceipt(){

    }
}
