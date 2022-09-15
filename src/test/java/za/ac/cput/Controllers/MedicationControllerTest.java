package za.ac.cput.Controllers;
// Onele Tomson (21948328)


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Factory.MedicationFactory;


import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class MedicationControllerTest {
    @LocalServerPort
    private int portNumber;
    @Autowired
    private MedicationController medicationController;
    @Autowired
    private TestRestTemplate restTemplate;
    private Medication medication;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(medicationController);
        this.medication = MedicationFactory.createMedication("122001","Painamol",54,5);
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/medication/";
    }

    @Test
    void a_save() {
        String url = urlBase + "saveMedication";
        System.out.println(url);

        ResponseEntity<Medication> medicationResponseEntity = this.restTemplate.postForEntity(url, this.medication, Medication.class);
        System.out.println(medicationResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,medicationResponseEntity.getStatusCode()),
                ()-> assertNotNull(medicationResponseEntity.getBody()));
        System.out.println("Medication saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readMedication/" + medication.getMedicationID();
        System.out.println(url);

        ResponseEntity<Medication> medicationResponseEntity = this.restTemplate.getForEntity(url, Medication.class);
        System.out.println(medicationResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,medicationResponseEntity.getStatusCode()),
                ()-> assertNotNull(medicationResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteMedication/" + medication.getMedicationID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",medication.getMedicationID()),
                ()->assertNotNull(medication.getMedicationName()));
        System.out.println("Successfully Deleted");
    }
    @Test
    void e_getAll() {
        String url = urlBase + "getMedication";
        System.out.println(url);

        ResponseEntity<Medication[]> responseEntity =this.restTemplate.getForEntity(url, Medication[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}
