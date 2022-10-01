package za.ac.cput.Repository;
/* IBillRepositoryTest.java
   Test for the IBillRepository(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IBillRepositoryTest {

    private final Bill bill= BillFactory.createBill("2001", "12345", "NOLU", 10);
    private final Bill bill1= BillFactory.createBill("2003", "123456", "BALO", 20);
    private final Bill bill2= BillFactory.createBill("2002", "34567", "Carstens", 30);

    @Autowired
    private IBillRepository repository;

    @Order(1)
    @Test void save()
    {
        //Bill save = this.repository.save(this.bill);
        Bill save1 = repository.save(bill1);
        assertNotNull(save1);
    }

    @Order(2)
    @Test void read()
    {
        Bill read = this.repository.getReferenceById(this.bill.getBillNo());
    }

    @Order(4)
    @Test void delete()
    {
        this.repository.delete(this.bill);
        List<Bill> billList = this.repository.findAll();
        assertSame(1, billList.size());
    }

    @Order(3)
    @Test void getAll()
    {
        List<Bill> billList = this.repository.findAll();
        assertSame(0, billList.size());
    }
}