package com.pluralsight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime orderTime;
    private List<Food> items = new ArrayList<>();


    public Order(){
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(Food item){
        items.add(item);
    }

    public double getTotal(){
        double total = 0;
         for (Food item: items){
             total += item.getPrice();
         }
         return total;
    }

    public String getReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("Taco The Town\n");
        receipt.append("Date: ").append(orderTime).append("\n");
        receipt.append("---------------------------------\n");

        for (Food item: items){
            receipt.append(item).append("\n");
        }

        receipt.append("---------------------------------\n");
        receipt.append(String.format("Total: $%.2f\n", getTotal()));
        return receipt.toString();
    }

    @Override
    public String toString(){
        return getReceipt();
    }
}
