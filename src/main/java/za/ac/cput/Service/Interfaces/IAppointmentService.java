package za.ac.cput.Service.Interfaces;

import za.ac.cput.Entity.Appointment;
import za.ac.cput.Service.IService;

import java.util.List;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

public interface IAppointmentService extends IService<Appointment, String> {
    List<Appointment> getAll();

}
