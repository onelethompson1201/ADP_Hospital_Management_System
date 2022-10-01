package za.ac.cput.Service.Impl;
/* BillServiceImplTest.java
   Test class: BillServiceImplTest(220021333)
   Author: Davin Shaun Carstens
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;
import za.ac.cput.Service.Impl.BillServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class BillServiceImplTest {
    private final Bill bill1 = BillFactory.createBill("19990330", "patient#24", "Jasmine"
            , 4500);
    private final Bill bill2 = BillFactory.createBill("19990331", "patient#25", "Davin"
            , 4500);
    private final Bill bill3 = BillFactory.createBill("19990332", "patient#26", "Mike"
            , 6800);
    private final Bill bill4 = BillFactory.createBill("19990333", "patient#27", "Anthony"
            , 8764);
    private final Bill bill5 = BillFactory.createBill("19990334", "patient#28", "Davids"
            , 9000);
    private final Bill bill6 = BillFactory.createBill("19990335", "patient#29", "Lizanne"
            , 67888);

    @Autowired private BillServiceImpl service;


    @Order(1)
    @Test void s_save() {
        System.out.println("Created:  ");
        Bill created1 = service.save(bill1);
        assertNotNull(created1);
        System.out.println(created1);

        Bill created2 = service.save(bill2);
        assertNotNull(created2);
        System.out.println(created2);

        Bill created3 = service.save(bill3);
        assertNotNull(created3);
        System.out.println(created3);

        Bill created4 = service.save(bill4);
        assertNotNull(created4);
        System.out.println(created4);

        Bill created5 = service.save(bill5);
        assertNotNull(created5);
        System.out.println(created5);

        Bill created6 = service.save(bill6);
        assertNotNull(created6);
        System.out.println(created6);
    }


    @Order(3)
    @Test void r_read() {
        Bill read = service.read(bill2.getBillNo());
        assertEquals(read.getBillNo(), bill2.getBillNo());
        System.out.println("Read:  " + read);
    }

    @Order(4)
    @Test void d_delete() {
        boolean success = service.delete(bill1.getBillNo());
        assertTrue(success);
        System.out.println( "Deleted:  " + success);
    }

    @Order(2)
    @Test void getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAll());
    }
}