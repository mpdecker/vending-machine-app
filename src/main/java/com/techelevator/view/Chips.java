package com.techelevator.view;

public class Chips extends Product{
    public Chips(double price, String name, String slotID) {
        super(price, name, slotID);
        this.setMessage("Crunch Crunch, Yum!");
    }
}
