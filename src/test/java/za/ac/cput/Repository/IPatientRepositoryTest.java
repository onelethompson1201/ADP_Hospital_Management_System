package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
IPatientRepositoryTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 13 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IPatientRepositoryTest {

    private IPatientRepository repository;
    private Patient patient;

    @BeforeEach
    void setUp(){
        Patient patient = PatientFactory.createPatient("Azolile Nxumalo","107 Mayday Crescent",765549876,"Male",27,"liveLong@08");
        assertNotNull(patient);
        System.out.println(patient);
    }

    @Test
    @Order(1)
    void save(){
        Patient save = this.repository.save(this.patient);
        assertEquals(this.patient, save);
    }

    @Test
    @Order(2)
    void read(){
        Patient read = this.repository.getById(this.patient.getPatientID());
    }

    @Test
    @Order(3)
    void findAll(){
        List<Patient> patientList = this.repository.findAll();
        assertSame(1, patientList.size());
    }

    @Test
    @Order(4)
    void delete(){
        this.repository.deleteById(this.patient.getPatientID());
        List<Patient> patientList = this.repository.findAll();
        assertSame(0, patientList.size());
    }



}

