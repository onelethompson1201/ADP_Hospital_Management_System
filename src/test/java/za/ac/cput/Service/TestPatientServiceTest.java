package za.ac.cput.Service;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.TestPatient;
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
class TestPatientServiceTest {

    private ITestPatientRepository repository;
    private TestPatientService service;

    private TestPatient testPatient;

    @BeforeEach
    void setUp(){
        this.service = new TestPatientService(repository);
        this.testPatient = TestPatientFactory.createTestPatient("Drug test");
        assertNotNull(testPatient);
    }

    @Test
    @Order(1)
    void save() {
        TestPatient save  = this.repository.save(this.testPatient);
        assertEquals(this.testPatient, save);
    }

    @Test
    @Order(2)
    void read() {
        TestPatient read = this.repository.findById(this.testPatient.getTestID()).orElse(null);
        assertEquals(this.testPatient, read);
    }


    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.testPatient.getTestID());
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(0, testPatientList.size());
    }

    @Test
    @Order(3)
    void getTestPatients(){
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(1, testPatientList.size());
    }
}