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

        switch (size.toUpperCase()) {
            case "S", "SMALL" -> price = 2.00;
            case "M", "MEDIUM" -> price = 2.50;
            case "L", "LARGE" -> price = 3.00;
            default -> price = 0.0;
        }
        return price;
    }

    @Override
    public String toString() {
        return flavor + " drink(" + size + ")"+ " @ $" + getPrice();
    }
}
