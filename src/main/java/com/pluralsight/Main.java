package com.pluralsight;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Order order = new Order("Christian");

       Pizza pizza = new Pizza("medium","regular");
       Drink drink = new Drink("medium","coke");
       GarlicKnots garlicKnots = new GarlicKnots(2);

       order.addItem(pizza);
       order.addItem(drink);
       order.addItem(garlicKnots);

       order.displayOrder();


    }
}