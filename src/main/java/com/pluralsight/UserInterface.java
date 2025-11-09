package com.pluralsight;

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
                case "1" -> addTaco();
                case "2" -> addDrink();
                case "3" -> addChips();
                case "4" -> checkout();
                case "0" -> ordering = false;
                default -> System.out.println("Error, try again.");

            }
        }
    }

    public void addTaco() {
        Taco taco = createTaco();

        sizeMenu();
         if (taco.getSize().equalsIgnoreCase("3 tacos")) {
             for (int i = 1; i <= 3; i++) {
                 System.out.println("Customizing taco #" + i);
                 selectToppings(taco);
             }
         }else {
             selectToppings(taco);
         }
             currentOrder.addItem(taco);
    }

    public void selectToppings(Taco taco){
        boolean adding = true;

        while (adding){
            toppingMenu();
            String choice = getInput("Select corresponding number: ");

            switch (choice) {
                case "1" -> taco.addTopping(new Topping(meatMenu(), "meat"));
                case "2" -> taco.addTopping(new Topping(cheeseMenu(), "cheese"));
                case "3" -> taco.addTopping(new Topping(regularToppingMenu(), "regular"));
                case "4" -> taco.addTopping(new Topping(sauceMenu(), "sauce"));
                case "0" -> adding = false;
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }



    public Taco createTaco(){
        String name;
        String shellType = "flour";
        String size = getInput("Select an option:");
        switch (size) {
            case "2" -> size = "3 tacos";
            case "3" -> size = "burrito";
            default -> size = "single";
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
           case "1" -> flavor = "strawberry";
           case "2" ->  flavor = "orange";
           case "3" -> flavor = "lemon";
       }
        Drink drink = new Drink("Drink", size.toLowerCase(), flavor);
        currentOrder.addItem(drink);
    }

    public void addChips(){
        Side chipsAndSalsa = new Side(1.5);
        currentOrder.addItem(chipsAndSalsa);
    }

    public void checkout(){
        System.out.println(currentOrder);
    }

    public void sizeMenu(){
        String menu = """
                1) Single
                2) 3 Tacos
                3) Burrito
                """;
        System.out.println(menu);
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
                0) Done customizing
                """;
        System.out.println(menu);
    }

    public String meatMenu(){
            String menu = """
                1) Carne Asada
                2) Al Pastor
                3) Carnitas
                4) Pollo
                5) Chorizo
                6) Pescado
                7) Back
                """;
            System.out.println(menu);
            String choice = getInput("Select an option: ");

            return switch (choice){
                case "1" -> "carne asada";
                case "2" -> "al pastor";
                case "3" -> "carnitas";
                case "4" -> "pollo";
                case "5" -> "chorizo";
                case "6" -> "pescado";
                case "7" -> "";
                default -> "NO MEAT";
            };
    }

    public String cheeseMenu(){
            String menu = """
                1) Queso Fresco
                2) Oaxaca
                3) Cotija
                4) Cheddar
                5) Back
                """;
            System.out.println(menu);
            String choice = getInput("Select an option: ");

            return switch (choice){
                case "1" -> "queso fresco";
                case "2" ->"oaxaca";
                case "3" -> "cotija";
                case "4" -> "cheddar";
                case "5" -> "";
                default -> "NO CHEESE";
            };
    }

    public String regularToppingMenu() {
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
                    0) Back
                    """;
            System.out.println(menu);
            String choice = getInput("Select an option: ");

            return switch (choice){
                case "1" -> "lettuce";
                case "2" -> "cilantro";
                case "3" -> "onions";
                case "4" -> "tomatoes";
                case "5" -> "jalepenos";
                case "6" -> "radishes";
                case "7" -> "pico de gallo";
                case "8" -> "guacamole";
                case "9" -> "corn";
                case "0" -> "";
                default -> "NO REG TOPPINGS";
            };
    }

    public String sauceMenu() {
            String menu = """
                    1) Salsa Verde
                    2) Salsa Rojo
                    3) Chipotle
                    4) Habanero
                    5) Mild
                    6) Extra Hot
                    """;
            System.out.println(menu);
            String choice = getInput("Select an option: ");

            return switch (choice) {
                case "1" -> "salsa verde";
                case "2" -> "salsa rojo";
                case "3" -> "chipotle";
                case "4" -> "habanero";
                case "5" -> "mild";
                case "6" -> "extra hot";
                default -> "NO SAUCE";
            };
    }

    public String getInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();

    }
}
