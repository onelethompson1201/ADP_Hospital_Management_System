package za.ac.cput.Repository;


//This is a worker class for Appointment entity under repository package.
//In this class we will be performing CRUD operations
//This is Appointment.java
import java.util.*;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Laboratory;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 08 April 2022
 */


public class AppointmentRepository implements IAppointment {


    public static AppointmentRepository repository = null;
    private Set<Appointment> appointmentsDB = null;


    private AppointmentRepository(){
        appointmentsDB = new HashSet<Appointment>();
    }

    public static AppointmentRepository getRepository() {
        if (repository == null)
        {
            repository = new AppointmentRepository();
        }
        return repository;
    }


    public Appointment create(Appointment appointment) {
        this.appointmentsDB.add(appointment);
        return appointment;


    }


    public Appointment read( String appointmentID) {
        Appointment appointment = appointmentsDB.stream().filter(e -> e.getAppointmentID().equals(appointmentID))
                .findAny().orElse(null);
        return appointment;

    }


    public Appointment update(Appointment appointment) {
        Appointment firstAppointment = read(appointment.getAppointmentID());
        if (firstAppointment != null) {
            appointmentsDB.remove(firstAppointment);
            appointmentsDB.add(appointment);
            return appointment;
        }
        return null;
    }

    public boolean  delete(String appointID) {
        Appointment deleteAppoint = read(appointID);
        if (deleteAppoint == null) {
            System.out.println("Appointment is null.");
            return false;
        }
        appointmentsDB.remove(deleteAppoint);
        System.out.println("Appointment card removed.");
            return true;
    }


    public Set<Appointment> getAll() {
        return appointmentsDB;
    }


}
