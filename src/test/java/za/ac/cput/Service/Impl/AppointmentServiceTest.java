package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
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
class AppointmentServiceTest {

    private IAppointmentRepository repository;
    private AppointmentService appointmentService;

    private Appointment appointment;
    private Department department;
    private Doctor doctor;


    @BeforeEach
    void setUp() {
        this.appointmentService = new AppointmentService(repository);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department, "Midwife Nurse");
        this.appointment = FactoryAppointment.createAppointment(doctor, "I think I have a headache", "12 Wednesday 2022", "August", "June");

        assertNotNull(appointment);
    }

    @Test
    @Order(1)
    void save() {
        Appointment save = this.repository.save(this.appointment);
        assertEquals(this.appointment, save);
    }

    @Test
    @Order(2)
    void read() {
        Appointment read = this.repository.findById(this.appointment.getAppointmentID()).orElse(null);
        assertEquals(this.appointment, read);
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.appointment.getAppointmentID());
        List<Appointment> appointmentList = this.repository.findAll();
        assertSame(0, appointmentList.size());
    }

    @Test
    @Order(3)
    void getAll() {
        List<Appointment> appointmentList = this.repository.findAll();
        assertSame(1, appointmentList.size());

    }

}