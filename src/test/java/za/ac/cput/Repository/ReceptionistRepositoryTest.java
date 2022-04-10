/* ReceptionistRepositoryTest.java
   Test class for Receptionist Repository
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ReceptionistRepositoryTest
{
    private static ReceptionistRepository repository = ReceptionistRepository.getRepository();
    private static Receptionist receptionist = ReceptionistFactory.createReceptionist("Floyd", "password", 12345);

    @Test
    void a_create()
    {
        Receptionist created = repository.create(receptionist);
        assertEquals(receptionist.getReceptionistID(), created.getReceptionistID());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read()
    {
        Receptionist read = repository.read(receptionist.getReceptionistID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update()
    {
        Receptionist updated = new Receptionist.Builder().copy(receptionist)
                .setReceptionistID("2321")
                .setReceptionistName("Ralph")
                .setReceptionistPassword("password")
                .setReceptionistTelephoneNumber(123456754)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(receptionist.getReceptionistID());
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