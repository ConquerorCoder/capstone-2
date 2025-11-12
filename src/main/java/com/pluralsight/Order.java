package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addPizza(Pizza p) {
        items.add(p);
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order for " + customerName + ":");
        for (OrderItem item : items) {
            System.out.println("- " + item.getDescription());
        }
        System.out.println("Total: $" + getTotalPrice());
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public String getCustomerName() {
        return customerName;
    }
}