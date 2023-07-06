package com.techelevator.view;

public class Drink extends Product{

    public Drink(double price, String name, String slotID) {
        super(price, name, slotID);
        this.setMessage("Glug Glug, Yum!");
    }

}
