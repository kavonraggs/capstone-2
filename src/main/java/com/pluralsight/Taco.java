package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Taco extends Food {
    private String size;
    private String shellType;
    private boolean deepFried;
    List<Topping> toppings = new ArrayList<>();

    public Taco(String name, String size, String shellType, boolean deepFried) {
        super(name);
        this.size = size;
        this.shellType = shellType;
        this.deepFried = deepFried;
    }

    public void addTopping(Topping t) {
        if (t != null){
            toppings.add(t);
        }
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
    public double getPrice() {
        double price = 0;

        switch (size.toLowerCase()) {
            case "single" -> price = 3.5;
            case "3 tacos" -> price = 9.0;
            case "burrito" -> price = 8.50;
        }
        for (Topping t : toppings) {
            price += t.getPrice(t.getCategory(), size);
        }
        if (deepFried) {
            price += 1;
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s)\n", getName(), getSize()));
        sb.append(String.format(" -Shell Type: %s\n", getShellType()));
        sb.append(String.format(" - Deep Fried: %s\n", isDeepFried() ? "Yes": "No"));
        sb.append(" - Toppings:\n");

        if (toppings.isEmpty()) {
            sb.append(" (no toppings)\n");
        } else {
            for (Topping t : toppings) {
                sb.append(String.format("%s %s", t.getName(), t.isExtra() ? " (extra)": ""));
            }
        }
        sb.append(String.format("\nTotal: $%.2f", getPrice()));
        return sb.toString();
    }

}
