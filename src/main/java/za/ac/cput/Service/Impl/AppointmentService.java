package za.ac.cput.Service.Impl;

import antlr.LexerSharedInputState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Repository.IAppointmentRepository;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */
@Service
public class AppointmentService{

    private final IAppointmentRepository repository;

    @Autowired
    public AppointmentService (IAppointmentRepository iAppointmentRepository){
        this.repository = iAppointmentRepository;
    }


    public Appointment saveAppointment (Appointment appointment){
        return this.repository.save(appointment);
    }

    public List<Appointment> saveAppointment (List<Appointment> appointmentList){
        return  this.repository.saveAll(appointmentList);
    }

    public Appointment readAppointment (String appointmentID){
        return this.repository.getById(appointmentID);
    }


    public boolean deleteAppointment (String appointmentID){

        if(this.repository.existsById(appointmentID)){
            this.repository.deleteById(appointmentID);

            return true;
        }
        return false;
    }

    public Appointment updateAppointment (Appointment appointment){
        Appointment existAppointment = repository.findById(appointment.getAppointmentID()).orElse(null);
        existAppointment.setAppointmentID(appointment.getAppointmentID());
        existAppointment.setDoctor(appointment.getDoctor());
        existAppointment.setAppointmentType(appointment.getAppointmentType());
        existAppointment.setAppointmentDescription(appointment.getAppointmentDescription());
        existAppointment.setAppointmentDay(appointment.getAppointmentDay());
        existAppointment.setAppointmentMonth(appointment.getAppointmentMonth());

        return this.repository.save(existAppointment);

    }


    public List<Appointment> getAppointment() {
        return repository.findAll();
    }
}
