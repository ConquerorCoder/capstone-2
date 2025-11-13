package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface() {
        scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        order = new Order(name);
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("Welcome To Papa Christians Pizzeria :} ");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Garlic Knots");
            System.out.println("3) Add Drink");
            System.out.println("4) View Order");
            System.out.println("5) Checkout");
            System.out.println("0) Exit");
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
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
    }

    private void addPizza() {
        System.out.println("Would you like:");
        System.out.println("1) Specialty Pizza");
        System.out.println("2) Custom Pizza");
        int choice = getIntInput();

        if (choice == 1) {
            System.out.println("Choose a Specialty Pizza:");
            System.out.println("1) Margherita");
            System.out.println("2) Veggie");
            System.out.println("3) Meat Lovers");
            int typeChoice = getIntInput();

            String name;
            if (typeChoice == 1) name = "Margherita";
            else if (typeChoice == 2) name = "Veggie";
            else name = "Meat Lovers";

            System.out.print("Enter size (small, medium, large): ");
            String size = scanner.nextLine();

            System.out.print("Enter crust type: ");
            String crust = scanner.nextLine();

            SpecialtyPizza specialty = new SpecialtyPizza(name, size, crust);
            order.addPizza(specialty);

            System.out.println(name + " pizza added!");
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
            System.out.println("Custom pizza added!");
        }
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

            System.out.println("Drink added!");
    }
    private void checkout() {
        System.out.println("CHECKOUT RECEIPT: ");

        order.displayOrder();

        System.out.println("------------------------------------");
        System.out.printf("TOTAL: $%.2f\n", order.getTotalPrice());
        System.out.println("====================================");
        System.out.println("Thank you for ordering, " + order.getCustomerName() + "!");

        ReceiptWriter writer = new ReceiptWriter();
        writer.saveReceipt(order);
    }
}

