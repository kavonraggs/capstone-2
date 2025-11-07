package com.pluralsight;

public abstract class Food {
    private String name;
    private double basePrice;


    public Food(String name, double basePrice){
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculatePrice();
}
