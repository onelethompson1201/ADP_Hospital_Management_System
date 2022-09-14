package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Factory.FactoryAppointment;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 15 September 2022
 */

class AppointmentControlllerTest {

    @LocalServerPort
    private int portNumber;

    @Autowired
    private AppointmentControlller appointmentControlller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Appointment appointment;
    private Department department;

    private String urlBase;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        assertNotNull(appointmentControlller);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");
        this.appointment = FactoryAppointment.createAppointment(doctor, "I think I have a headache", "12 Wednesday 2022", "August", "June");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/appointment/";
    }

    @Test
    void a_save() {
        String url = urlBase + "saveAppointment";
        System.out.println(url);

        ResponseEntity<Appointment> appointmentResponseEntity = this.restTemplate.postForEntity(url, this.appointment, Appointment.class);
        System.out.println(appointmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, appointmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(appointmentResponseEntity.getBody()));
        System.out.println("Appointment saved!");
    }

    @Test
    void b_read() {
        String url = urlBase + "readAppointment/" + appointment.getAppointmentID();
        System.out.println(url);

        ResponseEntity<Appointment> appointmentResponseEntity = this.restTemplate.postForEntity(url, this.appointment, Appointment.class);
        System.out.println(appointmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,appointmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(appointmentResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteAppointment/" + appointment.getAppointmentID();
        this.restTemplate.delete(url);

        assertAll(()->assertSame("1",appointment.getAppointmentID()),
                ()->assertNotNull(appointment.getAppointmentDay()));
        System.out.println("Delete successful!");
    }

    @Test
    void e_getAll() {
        String url = urlBase + "getAppointment";
        System.out.println(url);

        ResponseEntity<Appointment[]> responseEntity =this.restTemplate.getForEntity(url, Appointment[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }





}