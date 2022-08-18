package za.ac.cput.Factory;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 07 April 2022
 * This is an updated version
 */
import za.ac.cput.Entity.Appointment;
import za.ac.cput.util.Helper;

public class FactoryAppointment {

    public static Appointment createAppointment(String appointmentType, String appointmentDescription, String appointmentDay, String appointmentMonth){

        String appointmentID = Helper.generateAppointmentID();
        String doctorID = Helper.generateDoctorID();

        if (Helper.isNullorEmpty(appointmentDescription) || Helper.isNullorEmpty(appointmentDescription))
            return null;


        Appointment appointment = new Appointment.Builder().setAppointmentId(appointmentID)
                .setDoctorId(doctorID)
                .setAppointmentType(appointmentType)
                .setAppointmentDescription(appointmentDescription)
                .setAppointmentDay(appointmentDay)
                .setAppointmentMonth(appointmentMonth)
                .build();

        return appointment;

    }

}
