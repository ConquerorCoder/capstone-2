package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Order order;

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RESET = "\u001B[0m";

    public UserInterface() {
        scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        order = new Order(name);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("                                                                                                                                                \n" +
                            "▖  ▖    ▝▜                       ▗          ▗▄▄                  ▗▄ ▐        ▝       ▗   ▝                  ▗▄▄  ▝                   ▝       ▗  \n" +
                            "▌▐ ▌ ▄▖  ▐   ▄▖  ▄▖ ▗▄▄  ▄▖     ▗▟▄  ▄▖     ▐ ▝▌ ▄▖ ▗▄▖  ▄▖     ▗▘ ▘▐▗▖  ▖▄ ▗▄   ▄▖ ▗▟▄ ▗▄   ▄▖ ▗▗▖  ▄▖     ▐ ▝▌▗▄  ▗▄▄ ▗▄▄  ▄▖  ▖▄ ▗▄   ▄▖  ▐  \n" +
                            "▘▛▌▌▐▘▐  ▐  ▐▘▝ ▐▘▜ ▐▐▐ ▐▘▐      ▐  ▐▘▜     ▐▄▟▘▝ ▐ ▐▘▜ ▝ ▐     ▐   ▐▘▐  ▛ ▘ ▐  ▐ ▝  ▐   ▐  ▝ ▐ ▐▘▐ ▐ ▝     ▐▄▟▘ ▐    ▞   ▞ ▐▘▐  ▛ ▘ ▐  ▝ ▐  ▐  \n" +
                            "▐▌█▘▐▀▀  ▐  ▐   ▐ ▐ ▐▐▐ ▐▀▀      ▐  ▐ ▐     ▐   ▗▀▜ ▐ ▐ ▗▀▜     ▐   ▐ ▐  ▌   ▐   ▀▚  ▐   ▐  ▗▀▜ ▐ ▐  ▀▚     ▐    ▐   ▞   ▞  ▐▀▀  ▌   ▐  ▗▀▜  ▝  \n" +
                            "▐ ▐ ▝▙▞  ▝▄ ▝▙▞ ▝▙▛ ▐▐▐ ▝▙▞      ▝▄ ▝▙▛     ▐   ▝▄▜ ▐▙▛ ▝▄▜      ▚▄▘▐ ▐  ▌  ▗▟▄ ▝▄▞  ▝▄ ▗▟▄ ▝▄▜ ▐ ▐ ▝▄▞     ▐   ▗▟▄ ▐▄▄ ▐▄▄ ▝▙▞  ▌  ▗▟▄ ▝▄▜  ▐  \n" +
                            "                                                    ▐                                                                                           \n" +
                            "                                                    ▝                                                                                           ");
            System.out.println("Welcome To Papa Christians Pizzeria :} ");
            System.out.println("1) \uD83C\uDF55Add Pizza");
            System.out.println("2) \uD83E\uDD56Add Garlic Knots");
            System.out.println("3) \uD83E\uDDCBAdd Drink");
            System.out.println("4) \uD83E\uDDFEView Order");
            System.out.println("5) \uD83D\uDED2Checkout");
            System.out.println("0) \uD83D\uDCA8Exit");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1 -> addPizza();
                case 2 -> addGarlicKnots();
                case 3 -> addDrink();
                case 4 -> order.displayOrder();
                case 5 -> checkout();
                case 0 -> System.out.printf("\nTotal: $%.2f\n", order.getTotalPrice());
                default ->  System.out.println("Thank you for ordering, " + order.getCustomerName() + "!");

            }
        } while (choice != 0);
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print(RED + "Invalid input. Enter a number: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private void addPizza() {
        System.out.println("Would you like:");
        System.out.println("1) \uD83C\uDF1FSpecialty Pizza");
        System.out.println("2) \uD83E\uDEF5\uD83C\uDFFBCustom Pizza");
        int choice = getIntInput();

        if (choice == 1) {
            System.out.println("Choose a Specialty Pizza:");
            System.out.println("1) \uD83E\uDDC0Margherita");
            System.out.println("2) \uD83E\uDD6CVeggie");
            System.out.println("3) \uD83E\uDD53Meat Lovers");
            System.out.println("4) \uD83C\uDF57BBQ Chicken");
            System.out.println("5) \uD83C\uDF34Hawaiian Pizza");
            int typeChoice = getIntInput();

            String name;
            if (typeChoice == 1) name = "Margherita";
            else if (typeChoice == 2) name = "Veggie";
            else if (typeChoice == 3) name = "Meat Lovers";
            else if (typeChoice == 4) name = "BBQ Chicken";
            else name = "Hawaiian Pizza";

            System.out.print("Enter size (small, medium, large): ");
            String size = scanner.nextLine();

            System.out.print("Enter crust type: ");
            String crust = scanner.nextLine();

            SpecialtyPizza specialty = new SpecialtyPizza(name, size, crust);
            order.addPizza(specialty);

            System.out.print("Would you like to customize it? (yes/no): ");
            String customize = scanner.nextLine();

            if (customize.equalsIgnoreCase("yes")) {
                customizePizza(specialty);
            }


            System.out.println(GREEN + name + " pizza added!");
        }
        else if (choice == 2) {
            System.out.print("Enter size (small, medium, large): ");
            String size = scanner.nextLine();

            System.out.print("Enter crust type: ");
            String crust = scanner.nextLine();

            CustomPizza pizza = new CustomPizza(size, crust);

            System.out.print("Would you like stuffed crust? (yes/no): ");
            String stuffed = scanner.nextLine();
            if (stuffed.equalsIgnoreCase("yes")) {
                pizza.setStuffedCrust(true);
            }

            String topping;
            do {
                System.out.print("Add topping (or type 'ok'): ");
                topping = scanner.nextLine();
                if (!topping.equalsIgnoreCase("ok")) {
                    pizza.addTopping(topping);
                }
            } while (!topping.equalsIgnoreCase("ok"));

            order.addPizza(pizza);
            System.out.println(GREEN + "Custom pizza added!");
        }
    }
    private void customizePizza(Pizza pizza) {
        String action;
        do {
            System.out.println("Would you like to add or remove a topping?");
            System.out.print("Type 'add', 'remove', or 'ok' to finish: ");
            action = scanner.nextLine();


            if (action.equalsIgnoreCase("add")) {
                System.out.print("Enter topping to add: ");
                String topping = scanner.nextLine();
                pizza.addTopping(topping);
                System.out.println(topping + " added!");
            }
            else if (action.equalsIgnoreCase("remove")) {
                System.out.print("Enter topping to remove: ");
                String topping = scanner.nextLine();
                pizza.removeTopping(topping);
                System.out.println(RED + topping + " removed!");
            }
        } while (!action.equalsIgnoreCase("ok"));
    }

    private void addGarlicKnots() {
        System.out.print("Enter quantity: ");
        int qty = getIntInput();

        GarlicKnots knots = new GarlicKnots(qty);
        order.addItem(knots);

        System.out.println("Garlic knots added!");
    }
        private void addDrink() {
            System.out.print("Enter drink flavor: ");
            String flavor = scanner.nextLine();

            System.out.print("Enter size (small, medium, large): ");
            String size = scanner.nextLine();

            Drink drink = new Drink(size, flavor);
            order.addItem(drink);

            System.out.println(GREEN + "Drink added!");
    }
    private void checkout() {
        System.out.println("CHECKOUT RECEIPT: ");

        order.displayOrder();

        System.out.println("------------------------------------");
        System.out.printf("TOTAL: $%.2f\n", order.getTotalPrice());
        System.out.println("====================================");
        System.out.println(GREEN + "Thank you for ordering, " + order.getCustomerName() + "!");

        ReceiptWriter writer = new ReceiptWriter();
        writer.saveReceipt(order);
    }
}

