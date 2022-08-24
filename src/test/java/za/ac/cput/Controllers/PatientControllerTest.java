package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
/*
PatientControllerTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 22 August 2022
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PatientControllerTest {
    @LocalServerPort
    private int portNumber;
    @Autowired
    private PatientController patientController;
    @Autowired
    private TestRestTemplate restTemplate;
    private Patient patient;
    private String urlBase;


    @BeforeEach
    void setUp() {
        assertNotNull(patientController);
        this.patient = PatientFactory.createPatient("Zolile Khumalo","67 Nomyayi Street",+685346765,"Male",23,"HealthyLife@675");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/patient/";
    }

    @Test
    void a_save() {
        String url = urlBase + "savePatient";
        System.out.println(url);

        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.postForEntity(url, this.patient, Patient.class);
        System.out.println(patientResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));
        System.out.println("Patient saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readPatient/" + patient.getPatientID();
        System.out.println(url);

        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.getForEntity(url, Patient.class);
        System.out.println(patientResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deletePatient/" + patient.getPatientID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",patient.getPatientID()),
                ()->assertNotNull(patient.getPatientName()));
        System.out.println("Delete successful!");
    }

    @Test
    void e_getAll() {
        String url = urlBase + "getPatients";
        System.out.println(url);

        ResponseEntity<Patient[]> responseEntity =this.restTemplate.getForEntity(url, Patient[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}