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

    public String getSize() {
        return size;
    }

    public String getShellType() {
        return shellType;
    }

    public boolean isDeepFried() {
        return deepFried;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setDeepFried(boolean deepFried) {
        this.deepFried = deepFried;
    }

    @Override
    public double calculatePrice() {
        // base price + size + shell + toppings + deepfried
    }


}
