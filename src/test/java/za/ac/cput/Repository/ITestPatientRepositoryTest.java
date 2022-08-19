package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.class)
class ITestPatientRepositoryTest {
    private ITestPatientRepository repository;
    private TestPatient testPatient;

    @BeforeEach
    void setUp(){
        Patient patient = PatientFactory.createPatient("Azolile Nxumalo","107 Mayday Crescent",+765549876,"Male",27,"liveLong@08");
        TestPatient testPatient = TestPatientFactory.createTestPatient("Blood test", patient);
        assertNotNull(testPatient);
        System.out.println(testPatient);
    }

    @Test
    @Order(1)
    void save(){
        TestPatient save = this.repository.save(this.testPatient);
        assertEquals(this.testPatient, save);
    }

    @Test
    @Order(2)
    void read(){
        TestPatient read = this.repository.getById(this.testPatient.getTestID());
    }

    @Test
    @Order(3)
    void findAll(){
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(1, testPatientList.size());
    }

    @Test
    @Order(4)
    void delete(){
        this.repository.deleteById(this.testPatient.getTestID());
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(0, testPatientList.size());
    }




}