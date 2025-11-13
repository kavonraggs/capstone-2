package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime orderTime;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
    private List<Food> items = new ArrayList<>();


    public Order(){
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(Food item){
        items.add(item);
    }

    public List<Food> getItems() {
        return items;
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
        receipt.append("Date: ").append(orderTime.format(fmt)).append("\n");
        receipt.append("---------------------------------\n");

        for (Food item: items){
            receipt.append(item).append("\n");
        }

        receipt.append("---------------------------------\n");
        receipt.append(String.format("Total: $%.2f\n", getTotal()));
        return receipt.toString();
    }

    public void saveReceipt(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        DateTimeFormatter displayReceipt = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String folderName = "receipts";
        String fileName = folderName + "/" + orderTime.format(fmt) + ".csv";

        File folder = new File(folderName);

        if (!folder.exists()){
            boolean fileCreated = folder.mkdir();

            if (fileCreated){
                System.out.println("Folder created");
            }else {
                System.out.println("Error creating file");
                return;
            }
        }

        try(BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileName
        ))){
            buffWrite.write("Date,Item,Description,Price\n");

            for (Food item: items){
                buffWrite.write(String.format("%s,%s,%s,%.2f\n", orderTime.format(displayReceipt), item.getClass().getSimpleName(), item.getName(), item.getPrice()));
            }

            buffWrite.write(String.format(",,Total,%.2f\n", getTotal()));
            System.out.println("Receipt saved - " + fileName);

        } catch (IOException e){
            System.out.println("Error saving receipt");

        }

    }

    @Override
    public String toString(){
        return getReceipt();
    }
}
