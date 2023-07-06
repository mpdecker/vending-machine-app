package com.techelevator;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VendingMachineLogger {
    private  PrintWriter writer;
    public VendingMachineLogger() throws IOException {

        writer = new PrintWriter(new FileWriter("Log.txt", true), true);
    }
    public void logTransaction(String action, double amount, double balance) {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("MM/dd/yyy hh:mm:ss a");
        String formattedTimestamp = timestamp.format(formatterDate);
        writer.println(formattedTimestamp + " " + action + ": $" + amount + " $" + balance);
    }
    public String formatDollar(double amount) {
        DecimalFormat formatterDollar = new DecimalFormat("$0.00");
        return formatterDollar.format(amount);
    }
    public void logFeedMoney(double amount, double balance) {
        logTransaction("Feed Money", amount, balance);
    }
    public void logPurchase(String name, String id, double amount, double balance) {
        logTransaction(name+" "+id, amount, balance);
    }
    public void logGiveChange(double amount, double balance) {
        logTransaction("Give Change", amount, balance);
    }

}

