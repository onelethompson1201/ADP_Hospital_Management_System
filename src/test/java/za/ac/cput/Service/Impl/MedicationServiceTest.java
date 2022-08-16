package za.ac.cput.Service.Impl;


import org.junit.jupiter.api.*;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.MedicationFactory;
import za.ac.cput.Factory.TestResultsFactory;
import za.ac.cput.Repository.IMedicationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MedicationServiceTest {

    private IMedicationRepository repository;
    private MedicationServiceImpl service;

    private Medication medication;
    private TestResults testResults;


    @BeforeEach
    void setUp(){
        //this.service = new MedicationServiceImpl(repository);
        this.testResults = TestResultsFactory.createTestResults("Onnie","Female","4586","12 January 22","HIV test");
        this.medication = MedicationFactory.createMedication("4586","ARV",10f,31);
        assertNotNull(medication);
    }

    @Test
    @Order(1)
    void save() {
        Medication save = this.repository.save(this.medication);
        assertEquals(this.medication, save);
    }

    @Test
    @Order(2)
    void read() {
        Medication read = this.repository.findById(this.medication.getMedicationID()).orElse(null);
        assertEquals(this.medication, read);
    }

    @Test
    @Order(3)
    void getDoctors() {
        List<Medication> MedicationList = this.repository.findAll();
        assertSame(1, MedicationList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.medication.getMedicationID());
        List<Medication> medicationList = this.repository.findAll();
        assertSame(0, medicationList.size());
    }

}
