package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Factory.MedicationFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IMedicationRepositoryTest {

    private IMedicationRepository repository;

    private Medication medication;

    @BeforeEach
    void setUp() {
        this.medication = MedicationFactory.createMedication("122001", "Adcodol",
                55, 10);
        assertNotNull(medication);
    }

    @Test
    @Order(1)
    void save()
    {
        Medication save = this.repository.save(this.medication);
        assertEquals(this.medication, save);
    }

    @Test
    @Order(2)
    void read() {
        Medication read = this.repository.getById(this.medication.getMedicationID());
    }
    @Test
    @Order(3)
    void findAll()
    {
        List<Medication> medicationList = this.repository.findAll();
        assertSame(1, medicationList.size());
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.medication.getMedicationID());
        List<Medication> medicationList = this.repository.findAll();
        assertSame(0, medicationList.size());
    }

}
