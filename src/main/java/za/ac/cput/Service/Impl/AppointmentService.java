package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Repository.IAppointmentRepository;
import za.ac.cput.Service.Interfaces.IAppointmentService;

import java.util.List;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

public class AppointmentService  implements IAppointmentService {

    private final IAppointmentRepository repository;

    @Autowired
    public AppointmentService (IAppointmentRepository iAppointmentRepository){
        this.repository = iAppointmentRepository;
    }

    @Override
    public Appointment save (Appointment appointment){
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read (String appointmentID){
        return this.repository.getById(appointmentID);
    }

    @Override
    public boolean delete (String appointmentID){

        if(this.repository.existsById(appointmentID)){
            this.repository.deleteById(appointmentID);

            return true;
        }
        return false;
    }

    @Override
    public List<Appointment> getAll(){

        return this.repository.findAll();
    }

}
