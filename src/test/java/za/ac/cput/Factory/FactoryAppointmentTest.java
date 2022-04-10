package za.ac.cput.Factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Factory.FactoryAppointment;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//In this class I will test an entity called appointment, I built using a factory method.
//I will test it using the data

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *
 */


class FactoryAppointmentTest {

    @Test
    public void test() {
        Appointment appointment = FactoryAppointment.createAppointment(
                "Sickness",
        "I have a headache",
        "On monday at 1pm",
        "12 April 2022");
        System.out.println(appointment.toString());
        assertNotNull(appointment);

    }

}