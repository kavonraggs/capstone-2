package com.pluralsight;

public class Topping {
    private String name;
    private String category;
    private boolean extra;

    public double getPrice(String category, String size){
        double price = 0;

        switch (category.toLowerCase()){
            case "meat" -> {
                switch (size.toLowerCase()){
                    case "single" -> price = 1 + (extra ? 0.5 : 0);
                    case "3 tacos" -> price = 2 + (extra ? 1 : 0);
                    case "burrito" -> price = 3 + (extra ? 1.50 : 0);
                }
            }
            case "cheese" -> {
                switch (size.toLowerCase()){
                    case "single" -> price = 0.75 + (extra ? 0.30 : 0);
                    case "3 tacos" -> price = 1.50 + (extra ? 0.60 : 0);
                    case "burrito" -> price = 2.25 + (extra ? 0.90 : 0);
                }
            }

        }

        return price;
    }





}
