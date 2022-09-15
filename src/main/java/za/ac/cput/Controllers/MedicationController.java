package za.ac.cput.Controllers;

//Onele Tomson (219483280)

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Medication;
import za.ac.cput.Service.Impl.MedicationServiceImpl;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/medication/")
@Slf4j
public class MedicationController {

    private MedicationServiceImpl medicationServiceImpl;

    @Autowired
    MedicationController(MedicationServiceImpl medicationServiceImpl)
    {
        this.medicationServiceImpl = medicationServiceImpl;
    }

    @PostMapping("save/medication")
    public ResponseEntity<Medication> save(@Valid @RequestBody Medication medication)
    {
        log.info("Save Request: {}", medication);
        Medication save = this.medicationServiceImpl.save(medication);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getMedication/{id}")
    public ResponseEntity<Medication> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Medication read = this.medicationServiceImpl.read(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteMedication/{id}")
    public ResponseEntity<Medication> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.medicationServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

 /*   @GetMapping("getAll/medication")
    public ResponseEntity<Set<Medication>> getAll()
    {
        Set<Medication> medicationSet = this.medicationServiceImpl.getAll();
        return ResponseEntity.ok(medicationSet);
    }

  */
}





