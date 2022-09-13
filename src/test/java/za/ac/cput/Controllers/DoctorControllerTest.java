package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DoctorControllerTest {

    @LocalServerPort
    private int portNumber;

    @Autowired
    private DoctorController doctorController;

    @Autowired
    private TestRestTemplate restTemplate;

    private Doctor doctor;
    private Department department;

    private String urlBase;


    @BeforeEach
    void setUp() {
        assertNotNull(doctorController);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/doctor/";
    }

    @Test
    void a_save() {
        String url = urlBase + "saveDoctor";
        System.out.println(url);

        ResponseEntity<Doctor> doctorResponseEntity = this.restTemplate.postForEntity(url, this.doctor, Doctor.class);
        System.out.println(doctorResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, doctorResponseEntity.getStatusCode()),
                ()-> assertNotNull(doctorResponseEntity.getBody()));
        System.out.println("Doctor saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readDoctor/" + doctor.getDoctorID();
        System.out.println(url);

        ResponseEntity<Doctor> doctorResponseEntity = this.restTemplate.getForEntity(url, Doctor.class);
        System.out.println(doctorResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,doctorResponseEntity.getStatusCode()),
                ()-> assertNotNull(doctorResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteDoctor/" + doctor.getDoctorID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",doctor.getDoctorID()),
                ()->assertNotNull(doctor.getDoctorName()));
        System.out.println("Delete successful!");
    }

    @Test
    void e_getAll() {
        String url = urlBase + "getDoctors";
        System.out.println(url);

        ResponseEntity<Doctor[]> responseEntity =this.restTemplate.getForEntity(url, Doctor[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}