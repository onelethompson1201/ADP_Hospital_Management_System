package za.ac.cput.Service;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Repository.IPatientRepository;
import za.ac.cput.Service.Impl.PatientService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
PatientServiceTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 14 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientServiceTest {

    private IPatientRepository repository;
    private PatientService service;

    private Patient patient;

    @BeforeEach
    void setUp(){
        this.service = new PatientService(repository);
        this.patient = PatientFactory.createPatient("Anovuyo Mango", "67 Singxigxi Street", 782793833, "Female", 18, "healthy@0899");
        assertNotNull(patient);
    }

    @Test
    @Order(1)
    void save() {
        Patient save  = this.repository.save(this.patient);
        assertEquals(this.patient, save);
    }


    @Test
    @Order(2)
    void read() {
        Patient read = this.repository.findById(this.patient.getPatientID()).orElse(null);
        assertEquals(this.patient, read);
    }

    /*@Test
    void getPatientByName() {
        Patient read = this.repository.findByName(this.patient.getPatientName());
        assertEquals(this.patient, read);
    }*/

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.patient.getPatientID());
        List<Patient> patientList = this.repository.findAll();
        assertSame(0, patientList.size());
    }

    @Test
    @Order(3)
    void getPatients(){
        List<Patient> patientList = this.repository.findAll();
        assertSame(1, patientList.size());

    }
}