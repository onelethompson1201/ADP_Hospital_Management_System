package za.ac.cput.Controllers;
//This is a controller class
//This is a Controller.java
//This controller class is responsible for processing incoming REST API request, preparing a model and
//returning the view to be rendered as a response.

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Service.Impl.AppointmentService;

import javax.validation.Valid;
import java.util.Set;

/**
 * @author: Chuma Nxazonke
 * Student number: 219181187
 * Date: 13 September 2022
 */

@RestController
@RequestMapping("/hospital-management/appointment/")
@Slf4j
public class AppointmentControlller {

    private final AppointmentService appointmentService;

    @Autowired
    AppointmentControlller (AppointmentService appointmentService){

        this.appointmentService = appointmentService;

    }

    @PostMapping("save/appointment")
    public ResponseEntity<Appointment> save (@Valid @RequestBody Appointment saveAppointment) {

        log.info("save request: {}", saveAppointment);

        try {
            Appointment save = this.appointmentService.save(saveAppointment);
            return ResponseEntity.ok(save);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }
        @GetMapping("readAppointment/{appointmentID}")
        public ResponseEntity<Appointment> read(@PathVariable String appointmentID){
            log.info("Read request: {}", appointmentID);

            try{
                Appointment read = this.appointmentService.read(appointmentID);
                return ResponseEntity.ok(read);
            }
            catch(IllegalArgumentException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            }
        }

        @DeleteMapping("deleteAppointment/{appointmentID}")
        public ResponseEntity<Appointment> delete(@PathVariable String appointmentID)   {
            log.info("Appointment request: {}", appointmentID);
            this.appointmentService.delete(appointmentID);
            return ResponseEntity.noContent().build();
        }

        @GetMapping("getAll/appointment")
        public ResponseEntity<Set<Appointment>> getAll(){
            Set<Appointment> appointmentSet = this.appointmentService.getAll();
            return ResponseEntity.ok(appointmentSet);
        }


    }

