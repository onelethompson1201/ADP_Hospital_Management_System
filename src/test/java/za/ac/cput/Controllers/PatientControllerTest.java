package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class PatientControllerTest {
    private Patient patient;
    @LocalServerPort private int port;
    @Autowired private PatientController patientController;
    @Autowired private TestRestTemplate restTemplate;
    private String urlBase;

    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";


    @BeforeEach
    void setUp() {

        this.patient = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
        this.urlBase = "http://localhost:" + this.port + "/test_patient_db/patient/";
        assertNotNull(patientController);
    }

    @Test
    void a_create() {
        String url = urlBase + "savePatient";
        System.out.println(url);
        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.postForEntity(url, this.patient, Patient.class);
        System.out.println(patientResponseEntity);
        assertAll(()-> assertEquals(HttpStatus.OK, patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));
        System.out.println("Patient saved!");

        //Security
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("Create : " + url);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void b_read() {
        String url = urlBase + "readPatient/" + patient.getPatientID();
        System.out.println(url);
        ResponseEntity<Patient> patientResponseEntity = this.restTemplate.getForEntity(url, Patient.class);
        System.out.println(patientResponseEntity);
        assertAll(()-> assertEquals(HttpStatus.OK,patientResponseEntity.getStatusCode()),
                ()-> assertNotNull(patientResponseEntity.getBody()));

        //Security
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Read : ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void d_delete() {
        String url = urlBase + "deletePatient/" + patient.getPatientID();
        this.restTemplate.delete(url);
        assertAll(()->assertSame("1",patient.getPatientID()),
                ()->assertNotNull(patient.getPatientName()));
        System.out.println("Delete successful!");

        //Security
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.DELETE, entity, String.class);
        System.out.println("Delete: ");
        System.out.println(response);
        System.out.println(response.getBody());
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



        //Security
        HttpHeaders headers= new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: " + url);
        System.out.println(response);
        System.out.println(response.getBody());
    }


}