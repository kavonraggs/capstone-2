package com.pluralsight;

public class Side extends Food{
    private String salsaType;

    public Side(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}
