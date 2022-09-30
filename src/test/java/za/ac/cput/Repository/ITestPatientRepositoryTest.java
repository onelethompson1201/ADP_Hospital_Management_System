package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITestPatientRepositoryTest {
    //private Patient patient;
    private Patient patient = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");;
    private final TestPatient testPatient = TestPatientFactory.createTestPatient("Blood test",patient);
    @Autowired
    private ITestPatientRepository repository;



    @Order(1)
    @Test
    void save(){
        TestPatient save = this.repository.save(this.testPatient);
        assertEquals(this.testPatient, save);
    }


    @Order(2)
    @Test
    void read(){
        TestPatient read = this.repository.getReferenceById(this.testPatient.getTestID());
    }


    @Order(3)
    @Test
    void findAll(){
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(2, testPatientList.size());
    }


    @Order(4)
    @Test
    void delete(){
        this.repository.delete(this.testPatient);
        List<TestPatient> testPatientList = this.repository.findAll();
        assertSame(2, testPatientList.size());
    }




}