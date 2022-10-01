package za.ac.cput.Repository;
/* IReceptionistRepositoryTest.java
   Test for the IReceptionistRepository(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IReceptionistRepositoryTest {

    private final Receptionist receptionist = ReceptionistFactory.createReceptionist("Davin",
            "Shaun", "1234", 716172619);
    @Autowired
    private IReceptionistRepository repository;

    @Order(1)
    @Test void save()
    {
        Receptionist save = this.repository.save(this.receptionist);
        assertEquals(this.receptionist, save);
    }

    @Order(2)
    @Test void read()
    {
        Receptionist read = this.repository.getReferenceById(this.receptionist.getReceptionistID());
    }

    @Order(4)
    @Test void delete()
    {
        this.repository.deleteById(this.receptionist.getReceptionistID());
        List<Receptionist> receptionistList = this.repository.findAll();
        assertSame(0, receptionistList.size());
    }

//    @Order(3)
//    @Test void getAll()
//    {
//        List<Receptionist> receptionistList = this.repository.findAll();
//        assertSame(1, receptionistList.size());
//    }

}