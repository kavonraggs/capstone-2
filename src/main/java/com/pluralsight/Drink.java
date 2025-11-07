package com.pluralsight;

public class Drink extends Food {
    private String size;
    private String flavor;


    public Drink(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
