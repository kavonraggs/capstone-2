package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Order currentOrder = new Order();


    public void placeOrder(){
        boolean running = true;

        while (running){
            startMenu();

            String input = getInput("Enter corresponding number: ");
            switch (input.toLowerCase()){
                case "1" -> showMenu();
                case "0" -> running = false;
                default -> System.out.println("Error, try again");
                }
            }
        }

    public void startMenu(){
        String startMenu = """
                1) New Order
                0) Exit
                """;
        System.out.println(startMenu);
    }


    public void showMenu() {
        boolean ordering = true;

        while (ordering) {
            String orderScreen = """
                    1) Add Taco / Burrito
                    2) Add Drink
                    3) Add Chips & Salsa
                    4) Checkout
                    0) Cancel order
                    """;
            System.out.println(orderScreen);
            String choice = getInput("Select an option: ");

            switch (choice){
                case "1" -> addTaco(createTaco());
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> ordering = false;
                default -> System.out.println("Error, try again.");

            }

        }
    }

    public void addTaco(Taco taco) {
        String name;

        sizeMenu();
         if (taco.getSize().equalsIgnoreCase("3 tacos")){
            int i = 0;
            do {
            createTaco();
            toppingMenu();
            String choice = getInput("Select corresponding number: ");

            switch (choice){
                case "1" -> meatMenu();
                case "2" -> cheeseMenu();
                case "3" -> regularToppingMenu();
                case "4" -> sauceMenu();
            }


            i+= 1;
            }
            while (i != 3);
        } else {
             createTaco();
         }



    }

    public Taco createTaco(){
        String name;
        String shellType = "flour";
        String size = getInput("Select an option:");
        switch (size) {
            case "1" -> size.equals("single");
            case "2" -> size.equals("3 tacos");
            case "3" -> size.equals("burrito");
        }

        if (size.equalsIgnoreCase("burrito")){
            name = "Burrito";
        } else {
            name = "Taco";
            tacoShellMenu();
        }

        String deepFried = getInput("Deep fried? (Y/N)");
        boolean isFried;
        isFried = deepFried.equalsIgnoreCase("Y");

        return new Taco(name, size, shellType, isFried);
    }

    public void addDrink(){
        String drinkMenu = """
                Drink Sizes:
                S) Small
                M) Medium
                L) Large
                """;
        System.out.println(drinkMenu);
        String size = getInput("What size drink would you like? (S / M / L)");

        String flavorMenu = """
                1) Strawberry
                2) Orange
                3) Lemon
                """;
        System.out.println(flavorMenu);
       String flavor = getInput("What flavor drink would you like? ");

       switch (flavor){
           case "1" -> flavor.equals("strawberry");
           case "2" -> flavor.equals("orange");
           case "3" -> flavor.equals("lemon");
       }
        Drink drink = new Drink("Drink", size.toLowerCase(), flavor);
        currentOrder.addItem(drink);
    }

    public void addChips(){
        Side chipsAndSalsa = new Side(1.5);
        currentOrder.addItem(chipsAndSalsa);
    }

    public void checkout(){

    }


    public void sizeMenu(){
        String menu = """
                1) Single
                2) 3 Tacos
                3) Burrito
                """;
    }
    public void tacoShellMenu(){
        String menu = """
                1) Corn
                2) Flour
                3) Hard shell
                4) Bowl
                """;
        System.out.println(menu);

    }

    public void toppingMenu(){
        String menu = """
                Add toppings:
                1) Meat
                2) Cheese
                3) Other
                4) Select Sauces
                """;
        System.out.println(menu);
    }

    public void meatMenu(){
        String menu = """
                1) Carne Asada
                2) Al Pastor
                3) Carnitas
                4) Pollo
                5) Chorizo
                6) Pescado
                """;
        System.out.println(menu);

    }

    public void cheeseMenu(){
        String menu = """
                1) Queso Fresco
                2) Oaxaca
                3) Cotija
                4) Cheddar
                """;
    }

    public void regularToppingMenu(){
        String menu = """
                1) Lettuce
                2) Cilantro
                3) Onions
                4) Tomatoes
                5) Jalepenos
                6) Radishes
                7) Pico de Gallo
                8) Guacamole
                9) Corn
                """;

    }

    public void sauceMenu(){
        String menu = """
                1) Salsa Verde
                2) Salsa Rojo
                3) Chipotle
                4) Habanero
                5) Mild
                6) Extra Hot
                """;

    }


    public String getInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();

    }


}
