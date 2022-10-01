package za.ac.cput.Service.Impl;
/* ReceptionistServiceImplTest.java
   Test class: ReceptionistServiceImplTest(220021333)
   Author: Davin Shaun Carstens
*/
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;
import za.ac.cput.Service.Impl.ReceptionistServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReceptionistServiceImplTest {

    private final Receptionist receptionist = ReceptionistFactory.createReceptionist("Davin",
            "Shaun", "1234", 716172619);

    @Autowired private ReceptionistServiceImpl service;

    @Order(1)
    @Test void s_save() {
        System.out.println("Created:    ");
        Receptionist createdReceptionist = service.save(receptionist);
        assertNotNull(createdReceptionist);
        System.out.println(createdReceptionist);
    }

    @Order(2)
    @Test void r_read() {
        Receptionist read = service.read(receptionist.getReceptionistID());
        assertEquals(read.getReceptionistID(), receptionist.getReceptionistID());
        System.out.println("Read:   " + read);
    }

    @Order(3)
    @Test void d_delete() {
        boolean success = service.delete(receptionist.getReceptionistID());
        assertTrue(success);
        System.out.println("Deleted:    " + success);
    }
}