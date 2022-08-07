package za.ac.cput.Repository;
//This class I will test this entity using the specified method.
//This is RepositoryAppointmentTest.java

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Factory.FactoryAppointment;
import za.ac.cput.Repository.AppointmentRepository;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Chuma Edward Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 */




@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class RepositoryAppointmentTest {

    private static AppointmentRepository repository = AppointmentRepository.getRepository();
    private static Appointment appointment = FactoryAppointment.createAppointment(
            "HIV Checkout",
    "I wanna test for HIV",
    "On Tuesday at 3pm",
    "13 April 2022");


    @Order(1)
    @Test
    void create() {
        Appointment created = repository.create(appointment);
        assertEquals(created.getAppointmentID(), appointment.getAppointmentID());
        System.out.println("Appointment Card Created: " + created);
    }

    @Order(2)
    @Test
    void read() {
        Appointment read = repository.read(appointment.getAppointmentID());
        assertNotNull(read);
        System.out.println("Read: " + read);

    }
    @Order(3)
    @Test
    void update() {
        Appointment updateAppointment = new Appointment.Builder().Copy(appointment)
                .setAppointmentType("HIV Test")
                .setAppointmentDescription("I wanna test for HIV")
                .build();
        assertEquals(updateAppointment.getAppointmentID(), appointment.getAppointmentID());
        System.out.println("Updated Appointment card: " + updateAppointment);
    }

    @Order(4)
    @Test
    void delete() {
        repository.delete(appointment.getAppointmentID());
        assertNotNull(repository);
        System.out.println("Appointment card has been removed successfully");
    }

    @Order(5)
    @Test
    void getAll() {
        System.out.println("Appointment card: \n" + repository.getAll());


    }


}
