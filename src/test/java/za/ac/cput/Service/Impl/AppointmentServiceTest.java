package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Factory.FactoryAppointment;
import za.ac.cput.Repository.IAppointmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentServiceTest {



    private final Appointment appointment1 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "June");
    private final Appointment appointment2 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "July");
    private final Appointment appointment3 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "August");
    private final Appointment appointment4 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "September");
    private final Appointment appointment5 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "October");
    private final Appointment appointment6 = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache", "12 Wednesday 2022", "August", "November");


    @Autowired
    private AppointmentService service;


    @Order(1)
    @Test void s_save() {
        System.out.println("Created:  ");
        Appointment created1 = service.saveAppointment(appointment1);
        assertNotNull(created1);
        System.out.println(created1);

        Appointment created2 = service.saveAppointment(appointment2);
        assertNotNull(created2);
        System.out.println(created2);

        Appointment created3 = service.saveAppointment(appointment3);
        assertNotNull(created3);
        System.out.println(created3);

        Appointment created4 = service.saveAppointment(appointment4);
        assertNotNull(created4);
        System.out.println(created4);

        Appointment created5 = service.saveAppointment(appointment5);
        assertNotNull(created5);
        System.out.println(created5);

        Appointment created6 = service.saveAppointment(appointment6);
        assertNotNull(created6);
        System.out.println(created6);
    }


    @Order(3)
    @Test void r_read() {
        Appointment read = service.readAppointment(appointment1.getAppointmentID());
        assertEquals(read.getAppointmentID(), appointment2.getAppointmentDay());
        System.out.println("Read:  " + read);
    }

    @Order(4)
    @Test void u_update(){

    }

    @Order(5)
    @Test void d_delete() {
        boolean success = service.deleteAppointment(appointment1.getAppointmentID());
        assertTrue(success);
        System.out.println( "Deleted:  " + success);
    }

    @Order(2)
    @Test void getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAppointment());
    }

}