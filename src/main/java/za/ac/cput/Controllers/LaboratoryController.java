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
import za.ac.cput.Entity.Laboratory;

import za.ac.cput.Service.Impl.LaboratoryService;


import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 14 September 2022
 */

@RestController
@RequestMapping("/hospital-management/laboratory/")
@Slf4j
public class LaboratoryController {

    private LaboratoryService laboratoryService;


    @PostMapping("/addLaboratory")
    public Laboratory addLaboratory (@RequestBody Laboratory laboratory){
        return laboratoryService.saveLaboratory(laboratory);
    }

    @PostMapping("/addLaboratory")

    public List<Laboratory> addLaboratory (@RequestBody List<Laboratory> laboratoryList){
        return laboratoryService.getAllLaboratory();
    }

    @GetMapping ("/laboratory")
    public List<Laboratory> findAllLaboratory(){
        return laboratoryService.getAllLaboratory();
    }


    @PutMapping("/update")
    public Laboratory addUpdate (@RequestBody Laboratory laboratory){
        return laboratoryService.updateLaboratory(laboratory);
    }

    @DeleteMapping("/delete{labID}")
    public boolean deleteAppointment(@PathVariable String labID){
        return  laboratoryService.deleteLaboratory(labID);
    }


}