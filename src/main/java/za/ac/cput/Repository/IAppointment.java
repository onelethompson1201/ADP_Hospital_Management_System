package za.ac.cput.Repository;

import za.ac.cput.Entity.Appointment;

import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student Number: 219181187
 * Date: 08 April 2022
 *
 *
 */

public interface IAppointment extends IRepository<Appointment, String> {

    //CRUD operation performed
    public Set<Appointment> getAll();


}