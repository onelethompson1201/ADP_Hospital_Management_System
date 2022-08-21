package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;
import za.ac.cput.Repository.ITestPatientRepository;
import za.ac.cput.Service.Impl.TestPatientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
TestPatientServiceTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 14 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TestPatientServiceTest {

    private ITestPatientRepository repository;
    private TestPatientService service;

    private TestPatient testPatient;
    private Patient patient;

    @BeforeEach
    void setUp(){
        this.service = new TestPatientService(repository);
        this.patient = PatientFactory.createPatient("Anovuyo Mango", "67 Singxigxi Street", +782793833, "Female", 18, "healthy@0899");
        this.testPatient = TestPatientFactory.createTestPatient("Drug test", patient);
        assertNotNull(testPatient);
    }

    @Test

    void a_save() {
        TestPatient save  = this.repository.save(this.testPatient);
        assertEquals(this.testPatient, save);
    }

    @Test
    void b_read() {
        TestPatient read = this.repository.findById(this.testPatient.getTestID()).orElse(null);
        assertEquals(this.testPatient, read);
    }


    @Test
    void d_delete() {
        this.repository.deleteById(this.testPatient.getTestID());
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(0, testPatientList.size());
    }

    @Test
    void c_getTestPatients(){
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(1, testPatientList.size());
    }
}