/* BillRepositoryTest.java
   Test class for Bill Repository
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class BillRepositoryTest
{

    private static BillRepository repository = BillRepository.getRepository();
    private static Bill bill = BillFactory.createBill("12312", "FSF", 1213f);

    @Test
    void a_create()
    {
        Bill created = repository.create(bill);
        assertEquals(bill.getBillNo(), created.getBillNo());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read()
    {
        Bill read = repository.read(bill.getBillNo());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update()
    {
        Bill updated = new Bill.Builder().copy(bill)
                .setBillAmount(1123f)
                .setPatientID("1244654hkk")
                .setPatientName("Davin")
                .setBillNo("45")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(bill.getBillNo());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}