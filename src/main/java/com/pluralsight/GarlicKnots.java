package com.pluralsight;
public class GarlicKnots implements OrderItem {
    private int quantity;

    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        double price = 4.99;
        return price * quantity;
    }

    @Override
    public String toString() {
        return "GarlicKnots: " + quantity;
    }

    public String getDescription() {
        return quantity + " Garlic Knots";


    }
}