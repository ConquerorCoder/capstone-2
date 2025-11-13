package com.pluralsight;

public class SpecialtyPizza extends Pizza {
    private String name;
    private double extraCharge;

    public SpecialtyPizza(String name, String size, String crustType) {
        super(size, crustType);
        this.name = name;

        if (name.equalsIgnoreCase("Margherita")) {
            addTopping("Mozzarella");
            addTopping("Tomatoes");
            addTopping("Basil");
            addTopping("Marinara");
            addTopping("Olive Oil");
            extraCharge = 1.00; //
        }
        else if (name.equalsIgnoreCase("Veggie")) {
            addTopping("Bell Peppers");
            addTopping("Spinach");
            addTopping("Olives");
            addTopping("Onions");
            addTopping("Marinara");
            addTopping("Mozzarella");
            extraCharge = 2.00;
        }
        else if (name.equalsIgnoreCase("Meat Lovers")) {
            addTopping("Pepperoni");
            addTopping("Sausage");
            addTopping("Ham");
            addTopping("Bacon");
            addTopping("Mozzarella");
            addTopping("Marinara");
            extraCharge = 3.00;
        }
        else {
            extraCharge = 0.00;
            System.out.println("Unknown specialty pizza: " + name);
        }
    }

    @Override
    public double getPrice() {
        return super.getPrice() + extraCharge;
    }

    @Override
    public String getDescription() {
        return name + " (" + super.toString() + ")";
    }
}