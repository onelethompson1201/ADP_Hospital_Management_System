package za.ac.cput.Repository;

/* MedicationRepositoryTest.java
 Entity for the MedicationRepositoryTest
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Factory.MedicationFactory
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class MedicationRepositoryTest
{
    private static MedicationRepository repository = MedicationRepository.getRepository();
    private static Medication medication = MedicationFactory.createMedication(
            "122001", "Onele", 75, 5);

    @Test
    void a_create()
    {
        Medication created = repository.create(Medication);
        assertEquals(Medication.getMedicationID(), created.getMedicationID());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read()
    {
        Medication read = repository.read(Medication.getMedicationID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update()
    {
        Medication updated = new Medication.Builder().copy(Medication).setMedicationID("122001")
                .setMedicationName("Adcodol")
                .setMedicationPrice(75)
                .setMedicationQuantity(5)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(Medication.getMedicationID());
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
