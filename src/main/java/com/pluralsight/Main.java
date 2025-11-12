package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("small","stuffed crust");
        pizza.setStuffedCrust(true);
        System.out.println(pizza);
        System.out.println(pizza.getPrice());
    }
}