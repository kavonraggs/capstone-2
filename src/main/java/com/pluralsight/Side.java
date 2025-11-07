package com.pluralsight;

public class Side extends Food{

    public Side(double price) {
        super(price);
        price = 1.50;
    }


    @Override
    public double calculatePrice() {
        return 0;
    }
}
