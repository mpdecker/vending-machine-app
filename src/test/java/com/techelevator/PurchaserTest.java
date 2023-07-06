package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import com.techelevator.view.*;

public class PurchaserTest {

    @Test
    public void testPurchaseProduct() {
        VendingMachine p = new VendingMachine();
        p.makeInventory();
        Product item = p.getInventoryItem("A1");
        p.setUserBalance(5);
        p.purchaseProduct(item);
        int stockRemaining = item.getStock();
        Assert.assertEquals(4, stockRemaining);
    }
    @Test
    public void testBalanceReduction(){
        VendingMachine p = new VendingMachine();
        p.makeInventory();
        Product item = p.getInventoryItem("A1");
        p.setUserBalance(5);
        p.purchaseProduct(item);
        Assert.assertNotEquals(5, p.getUserBalance(), 0.0);

    }
    @Test
    public void testInStock(){
        VendingMachine p = new VendingMachine();
        p.makeInventory();
        Product item = p.getInventoryItem("A1");
        p.setUserBalance(5);
        item.setStock(1);
        p.purchaseProduct(item);
        Assert.assertFalse(item.isInStock());

    }
    @Test
    public void testDispenseChange() {
        Purchaser p = new Purchaser();
        String output = p.dispenseChange();
        Assert.assertTrue(output!=null);

    }
    @Test
    public void testBalanceZero(){
        Purchaser p = new Purchaser();
        p.dispenseChange();
        double output = p.getUserBalance();
        Assert.assertEquals(0, output, 0);

    }
    @Test
    public void testFeedMoney() {
        Purchaser p = new Purchaser();
        int amount = 5;
        p.feedMoney(amount);
        Assert.assertEquals(5, p.getUserBalance(), 0);

    }
}