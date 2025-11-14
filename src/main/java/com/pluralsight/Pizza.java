package com.pluralsight;

import java.util.ArrayList;

public class Pizza implements OrderItem {
    private final String size;
    private final String crustType;
    private final ArrayList<String> meats;
    private final ArrayList<String> cheeses;
    private final ArrayList<String> toppings;
    private boolean stuffedCrust;

    public Pizza(String size, String crustType) {
        this.size = size;
        this.crustType = crustType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.stuffedCrust = false;
    }

    public void addTopping(String topping) {
        String lower = topping.toLowerCase();

        if (lower.contains("pepperoni") || lower.contains("sausage") ||
                lower.contains("ham") || lower.contains("bacon") ||
                lower.contains("chicken") || lower.contains("meatball")) {
            meats.add(topping);
        }
        else if (lower.contains("cheese") || lower.contains("mozzarella") ||
                lower.contains("parmesan") || lower.contains("ricotta") ||
                lower.contains("goat") || lower.contains("buffalo")) {
            cheeses.add(topping);
        }
        else {
            toppings.add(topping);
        }
    }
    public void removeTopping(String topping) {
        for (int i = 0; i < meats.size(); i++) {
            if (meats.get(i).equalsIgnoreCase(topping)) {
                meats.remove(i);
                i--;
            }
        }
        for (int i = 0; i < cheeses.size(); i++) {
            if (cheeses.get(i).equalsIgnoreCase(topping)) {
                cheeses.remove(i);
                i--;
            }
        }
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).equalsIgnoreCase(topping)) {
                toppings.remove(i);
                i--;
            }
        }
    }


    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }
    public double getPrice() {
        double price = 0.0;
        if (size.equalsIgnoreCase("small")) {
            price = 7.40;
        }
        else if (size.equalsIgnoreCase("medium")) {
            price = 9.40;
        }
        else if (size.equalsIgnoreCase("large")) {
            price = 12.33;
        }

        price += toppings.size() * 1.00;

        if (stuffedCrust) {
            price += 1.50;
        }

        double meatPrice = 0.0;
        if (size.equalsIgnoreCase("small")) {
            meatPrice = 1.00;
        } else if (size.equalsIgnoreCase("medium")) {
            meatPrice = 2.00;
        } else if (size.equalsIgnoreCase("large")) {
            meatPrice = 3.00;
        }
        price += meats.size() * meatPrice;


        double cheesePrice = 0.0;
        if (size.equalsIgnoreCase("small")) {
            cheesePrice = 0.75;
        } else if (size.equalsIgnoreCase("medium")) {
            cheesePrice = 1.50;
        } else if (size.equalsIgnoreCase("large")) {
            cheesePrice = 2.25;
        }
        price += cheeses.size() * cheesePrice;

        return price;
    }

    public String toString() {
        StringBuilder text = new StringBuilder(size + " " + crustType + " pizza");

        ArrayList<String> allToppings = new ArrayList<>();
        allToppings.addAll(meats);
        allToppings.addAll(cheeses);
        allToppings.addAll(toppings);

        if (!allToppings.isEmpty()) {
            text.append(" with ").append(String.join(", ", allToppings));
        }
        return text.toString();
    }

    @Override
    public String getDescription() {
        return toString();
    }
}
