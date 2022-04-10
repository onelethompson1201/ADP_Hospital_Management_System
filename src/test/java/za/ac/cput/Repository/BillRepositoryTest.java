package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class BillRepositoryTest
{

    private static BillRepository repository = BillRepository.getRepository();
    private static Bill bill = BillFactory.createBill("1232", "1223"
            , "davin", 34f);

    @Test
    void a_create()
    {
        Bill created = repository.create(bill);
        assertEquals(bill.getBillNo(),created.getBillNo());
        System.out.println("Create: "+ created);
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
                .setBillNo("324")
                .setPatientName("Rolls")
                .setPatientID("D456")
                .setBillAmount(6666f)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(bill.getBillNo());
        assertTrue(success);
        System.out.println("Deleted" + true);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}