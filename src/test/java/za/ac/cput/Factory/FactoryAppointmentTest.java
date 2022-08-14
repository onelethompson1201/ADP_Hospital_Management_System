package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Factory.FactoryAppointment;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//In this class I will test an entity called appointment, I built using a factory method.
//I will test it using the data

/**
 * @author Chuma Edward Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *
 */


class FactoryAppointmentTest {

    @Test
    public void test() {
        Appointment appointment = FactoryAppointment.createAppointment(
                "Sickness",
        "I have a flue",
        "On monday at 11am",
        "12 April 2022");
        System.out.println(appointment.toString());
        assertNotNull(appointment);

    }

}