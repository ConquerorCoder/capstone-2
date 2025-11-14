package com.pluralsight;

public class Drink implements OrderItem {
private final String size;
private final String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return size + " " + flavor + " Drink";
    }

    @Override
    public double getPrice() {
        double price = 0.0;

        // Base price depending on size
        if (size.equalsIgnoreCase("small")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 2.40;
        } else if (size.equalsIgnoreCase("large")) {
            price = 2.99;
        }
        return price;

    }

    @Override
    public String toString() {
        return "Drink " +
                "size = " + size +
                ", flavor = " + flavor;
    }
}
