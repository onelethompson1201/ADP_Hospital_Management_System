package za.ac.cput.Service.Impl;
/* ReceptionistServiceImplTest.java
   Test class: ReceptionistServiceImplTest(220021333)
   Author: Davin Shaun Carstens
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;
import za.ac.cput.Service.Impl.ReceptionistServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ReceptionistServiceImplTest {

    @Autowired
    private ReceptionistServiceImpl service;

    private static Receptionist receptionist1 = ReceptionistFactory.createReceptionist("Rochelle", "ReceptionistRochelle"
    ,"Dog1234", 716172619);

    @Test
    void s_save() {
        System.out.println("Booking of: ");
        Receptionist receptionistUser = service.save(receptionist1);
        assertNotNull(receptionistUser);
        System.out.println(receptionistUser);
    }

    @Test
    void r_read() {
        Receptionist read = service.read(receptionist1.getReceptionistID());
        assertEquals(read.getReceptionistID(), receptionist1.getReceptionistID());
        System.out.println("Read:      " + read);
    }

    @Test
    void d_delete() {
        boolean success = service.delete(receptionist1.getReceptionistID());
        assertTrue(success);
        System.out.println("Deleted:    " + success);
    }
}