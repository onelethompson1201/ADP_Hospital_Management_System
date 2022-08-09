package za.ac.cput.Repository;
/* IReceptionistRepositoryTest.java
   Test for the IReceptionistRepository(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IReceptionistRepositoryTest {

    private IReceptionistRepository repository;
    private Receptionist receptionist;

    @BeforeEach
    void setUp(){
        Receptionist receptionist1 = ReceptionistFactory.createReceptionist("Rochelle",
                "Davin ", "admin", +716172619);
        assertNotNull(receptionist1);
        System.out.println(receptionist1);
    }

    @Test
    @Order(3)
    void getAll() {
        List<Receptionist> receptionistList = this.repository.findAll();
        assertSame(1, receptionistList.size());
    }

    @Test
    @Order(1)
    void save(){
        Receptionist save = this.repository.save(this.receptionist);
        assertEquals(this.receptionist, save);
    }

    @Test
    @Order(2)
    void read(){
        Receptionist read = this.repository.getReferenceById(this.receptionist.getReceptionistID());
    }

    @Test
    @Order(4)
    void delete(){
        this.repository.deleteById(this.receptionist.getReceptionistID());
        List<Receptionist> receptionistList = this.repository.findAll();
        assertSame(0, receptionistList.size());
    }

}