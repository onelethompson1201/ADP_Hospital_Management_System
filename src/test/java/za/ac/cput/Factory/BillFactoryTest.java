/* BillFactoryTest.java
   Test class for BillFactory
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Bill;

import static org.junit.jupiter.api.Assertions.*;

class BillFactoryTest
{
    @Test
    void createBill()
    {
        Bill bill = BillFactory.createBill("213", "davin", 23345);
        assertNotNull(bill);
        System.out.println(bill);
    }
}