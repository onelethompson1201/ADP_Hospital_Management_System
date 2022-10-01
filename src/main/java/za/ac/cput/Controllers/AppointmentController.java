package za.ac.cput.Controllers;

//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view


import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import za.ac.cput.Entity.Appointment;
import za.ac.cput.Repository.IAppointmentRepository;
import za.ac.cput.Service.Impl.AppointmentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
/**
 * @author: Chuma Nxazonke
 * Student number: 219181187
 * Date: 13 September 2022
 */
@RestController
@RequestMapping("/hospital-management/appointment/")
@Slf4j



public class AppointmentController {


    private AppointmentService appointmentService;


    @PostMapping("/addAppointment")
    public Appointment addAppointment (@RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @PostMapping("/addAppointment")

    public List<Appointment> addAppointment (@RequestBody List<Appointment> appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping ("/appointment")
    public List<Appointment> findAllAppointment(){
        return appointmentService.getAppointment();
    }


    @PutMapping("/update")
    public Appointment addUpdate (@RequestBody Appointment appointment){
        return appointmentService.updateAppointment(appointment);
    }

    @DeleteMapping("/delete{appointmentID}")
    public boolean deleteAppointment(@PathVariable String appointmentID){
        return  appointmentService.deleteAppointment(appointmentID);
    }




}
