package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Bill;

import static org.junit.jupiter.api.Assertions.*;

class BillFactoryTest
{
    @Test
    void createBill()
    {
        Bill bill = BillFactory.createBill("Davin", "12312","Davin", 12223f);
        assertNotNull(bill);
        System.out.println(bill);
    }
}