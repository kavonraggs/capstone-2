package com.pluralsight;

import java.util.List;

public class Taco extends Food{
    private String size;
    private String shellType;
    private boolean deepFried;
    List<Topping> toppings;

    public Taco(String name, double basePrice, String size, String shellType, boolean deepFried, List<Topping> toppings) {
        super(name, basePrice);
        this.size = size;
        this.shellType = shellType;
        this.deepFried = deepFried;
        this.toppings = toppings;
    }

    public void addTopping(Topping t){
        toppings.add(t);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }


}
