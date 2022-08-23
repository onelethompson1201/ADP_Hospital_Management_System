package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Service.Impl.PatientService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/administration/")
@Slf4j
public class PatientController {

    private PatientService patientService;

    @Autowired
    PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("save/patient")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient)
    {
       log.info("Save request: {}", patient);
       Patient save = this.patientService.save(patient);
       return ResponseEntity.ok(save);
    }

    @GetMapping("getPatient/{id}")
    public ResponseEntity<Patient> read(@PathVariable String id){
        log.info("Read request: {}", id);
        try{
            Patient read = this.patientService.read(id);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deletePatient/{id}")
    public ResponseEntity<Patient> delete(@PathVariable String id)   {
        log.info("Delete request:", id);
        this.patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getPatients/patient")
    public ResponseEntity<Set<Patient>> getAll(){
        Set<Patient> patientSet = (Set<Patient>) this.patientService.getPatients();
        return ResponseEntity.ok(patientSet);
    }




}
