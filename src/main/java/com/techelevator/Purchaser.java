package com.techelevator;
import com.techelevator.view.*;

import java.io.IOException;
import java.text.DecimalFormat;

public class Purchaser {
    private final double NICKEL = 0.05;

    private final double QUARTER = 0.25;
    private final double DIME = 0.1;
    private Product choice;
    private double userBalance=0;
    private VendingMachineLogger logger;


   /* public Purchaser(Product choice) {
        this.choice = choice;
    }*/

    public Product getChoice() {
        return choice;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public void setChoice(Product choice) {
        this.choice = choice;
    }

    //this method needs to take a slotID instead of a product
    public void purchaseProduct(Product c){
        //test effects not command line output
        try{
            logger = new VendingMachineLogger();
            double price = c.getPrice();
            if(price<userBalance&&c.isInStock()){
                userBalance-=price;
                c.setStock(c.getStock()-1);
                //  System.out.println(c.getName()+" "+c.getPrice()+" "+getUserBalance());
                //System.out.println(c.getMessage());
                if(c.getStock()==0){
                    c.setInStock(false);
                }
                logger.logPurchase(c.getName(), c.getSlotID(),c.getPrice(),userBalance);
            }
            else if(!c.isInStock()){
                System.out.println("SOLD OUT");
            }
            else if(price>userBalance){
                System.out.println("Insufficient funds provided.");
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }
    public String dispenseChange(){
        //return something
        //needs fixing
        try{
            logger = new VendingMachineLogger();
            DecimalFormat format = new DecimalFormat("0.00");
            double numQuarters = Math.floor(userBalance/QUARTER);
            double remainder = Double.parseDouble(format.format(userBalance%QUARTER));
            double numDimes = Math.floor(remainder/DIME);
            remainder = Double.parseDouble(format.format(remainder%DIME));
            double numNickels = Math.floor(remainder/NICKEL);
            double totalDispensed = numQuarters*QUARTER+numDimes*DIME+numNickels*NICKEL;
            setUserBalance(0);
            logger.logGiveChange(totalDispensed, 0);
            String output = "Change Dispensed: "+numQuarters+" quarters, "+numDimes+" dimes, "+numNickels+" nickels.";
            return output;

        }catch(IOException e){
            System.out.println("Error"+e.getMessage());
        }
        return null;


    }
    public void feedMoney(double amount){
        try{
            logger = new VendingMachineLogger();
            userBalance+=amount;
            logger.logFeedMoney(amount,userBalance);
        }catch (IOException e){
            System.out.println("Error:" +e.getMessage());
        }
    }
}
