package com.pluralsight;

public class Topping {
    private String name;
    private String category;
    private boolean extra;

    public double getPrice(String category, String size){
        double price = 0;
        if (this.category.equalsIgnoreCase("meat")){
            if (size.equalsIgnoreCase("single")){
                price = 1;
                if (extra){
                    price += .50;
                }
            }
            else if (size.equalsIgnoreCase("3 tacos")) {
                price = 2;
                if (extra){
                    price += 1;
                }
            }
            else if (size.equalsIgnoreCase("burrito")){
                price = 3;
                if (extra){
                    price += 1.50;
                }
            }
        }
        else if (category.equalsIgnoreCase("cheese")){
            if (size.equalsIgnoreCase("single")){
                price = 0.75;
                if (extra){
                    price += .30;
                }
            }
            else if (size.equalsIgnoreCase("3 tacos")) {
                price = 1.50;
                if (extra){
                    price += .60;
                }
            }
            else if (size.equalsIgnoreCase("burrito")){
                price = 2.25;
                if (extra){
                    price += .90;
                }
            }
        }
        return price;
    }





}
