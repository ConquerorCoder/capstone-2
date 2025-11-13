package com.pluralsight;

public class CustomPizza extends Pizza {
    public CustomPizza(String size, String crustType) {
        super(size, crustType);
    }

    @Override
    public String getDescription() {
        return "Custom " + super.toString();
    }
}