package com.pluralsight;

public class Side extends Food{

    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("%s @ $%.2f",getName(),getPrice()) ;
    }
}
