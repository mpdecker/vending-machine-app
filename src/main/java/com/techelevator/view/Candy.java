package com.techelevator.view;

public class Candy extends Product{
    public Candy(double price, String name, String slotID) {
        super(price, name, slotID);
        this.setMessage("Munch Munch, Yum!");
    }
}
