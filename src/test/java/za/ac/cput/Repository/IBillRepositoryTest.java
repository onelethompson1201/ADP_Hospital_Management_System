package za.ac.cput.Repository;
/* IBillRepositoryTest.java
   Test for the IBillRepository(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IBillRepositoryTest {

    private IBillRepository repository;
    private Bill bill;

    @BeforeEach
    void setUp() {
        Bill bill = BillFactory.createBill("990330", "165432",
                "Lionel", 430000);
        assertNotNull(bill);
        System.out.println(bill);
    }
    @Test
    @Order(1)
    void save(){
        Bill save = this.repository.save(this.bill);
        assertEquals(this.bill, save);
    }

    @Test
    @Order(2)
    void read(){
        Bill read = this.repository.getReferenceById(this.bill.getBillNo());
    }

    @Test
    @Order(4)
    void delete(){
        this.repository.deleteById(this.bill.getBillNo());
        List<Bill> billList = this.repository.findAll();
        assertSame(0, billList.size());
    }

    @Test
    @Order(3)
    void getAll() {
        List<Bill> billList = this.repository.findAll();
        assertSame(1, billList.size());
    }
}