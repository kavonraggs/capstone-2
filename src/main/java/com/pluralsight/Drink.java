package com.pluralsight;

public class Drink extends Food {
    private String size;
    private String flavor;

    public Drink(String name, String size, String flavor) {
        super(name);
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() { double price = 0;

        switch (size.toLowerCase()) {
            case "small" -> price = 2;
            case "medium" -> price = 2.50;
            case "large" -> price = 3;
        }
        return price;
    }
}
