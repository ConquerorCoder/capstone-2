package com.pluralsight;

import java.util.ArrayList;

public class Pizza implements OrderItem {
    private String size;
    private String crustType;
    private ArrayList<String> toppings;
    private boolean stuffedCrust;

    public Pizza(String size, String crustType) {
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
        this.stuffedCrust = false;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        this.stuffedCrust = stuffedCrust;
    }

    public double getPrice() {
        double price = 0.0;

        // Base price depends on size
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

        return price;
    }

    public String toString() {
        String text = size + " " + crustType + " Pizza";

        return text;
    }

    @Override
    public String getDescription() {
        return toString();
    }
}
