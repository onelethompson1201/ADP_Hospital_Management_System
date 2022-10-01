package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Appointment;


import za.ac.cput.Factory.FactoryAppointment;

import java.util.List;

/**
 * @author:  Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 July 2022
 * This is an updated version
 */


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IAppointmentRepositoryTest {
    private IAppointmentRepository repository;
    private Appointment appointment;



    @BeforeEach
    void setUp(){

        Appointment appointment = FactoryAppointment.createAppointment("Dr Nxazonke", "I think I have a headache","12 Wednesday 2022","August", "June");

        assertNotNull(appointment);
        System.out.println(appointment);
    }

    @Test
    @Order(1)
    void save(){
        Appointment save = this.repository.save(this.appointment);
        assertEquals(this.appointment,save);
    }

    @Test
    @Order(2)
    void read() {
        Appointment read = this.repository.getById(this.appointment.getAppointmentID());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Appointment> appointmentList = this.repository.findAll();
        assertSame(1, appointmentList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.appointment.getAppointmentID());
        List<Appointment> appointmentList = this.repository.findAll();
        assertSame(0, appointmentList.size());
    }
}