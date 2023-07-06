package com.techelevator;

import com.techelevator.view.Chips;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import com.techelevator.view.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class VendingMachineTest{
    @Test
    public void testMakeInventory() {
        VendingMachine v = new VendingMachine();
        v.makeInventory();
        Set<String> ids = new HashSet<>();
        int c = 0;
        for( Product p : v.inventory){
            ids.add(p.getSlotID());
            c=p.getSlotID().length();
        }
        Assert.assertTrue(ids.contains("D3"));
        Assert.assertFalse(ids.contains("H5"));
        Assert.assertFalse(c!=2);


    }
    @Test
    public void testGetInventoryItem() {
        VendingMachine v = new VendingMachine();
        v.makeInventory();
        Product item = v.inventory.get(0);
        Assert.assertEquals("A1", item.getSlotID());
        Assert.assertEquals("Potato Crisps", item.getName());
        Assert.assertEquals(3.05, item.getPrice(), 0.00);
        //Assert.assertEquals()
    }
    @Test

    public void testMakeInventoryItem() {
        Product p = new Chips(3.05, "Potato Crisps", "A1");
        Assert.assertEquals(3.05, p.getPrice(), 0.00);
        Assert.assertEquals("Potato Crisps", p.getName());
        Assert.assertEquals("A1", p.getSlotID());
        Assert.assertEquals(5, p.getStock());
        Assert.assertEquals(true, p.isInStock());
        Assert.assertEquals("Crunch Crunch, Yum!", p.getMessage());
    }
}