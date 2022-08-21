/*
        Author: Duncan Benjamin Harris
        Student Number: 220110530
        21/08/2022
*/

package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Service.Impl.MedicalRecordsService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/medicalRecords/")
@Slf4j
public class MedicalRecordsController
{
    private MedicalRecordsService medicalRecordsService;

    @Autowired
    MedicalRecordsController(MedicalRecordsService medicalRecordsService)
    {
        this.medicalRecordsService = medicalRecordsService;
    }

    @PostMapping("save/medicalRecords")
    public ResponseEntity<MedicalRecords> save(@Valid @RequestBody MedicalRecords medicalRecords)
    {
        log.info("Save Request: {}", medicalRecords);
        MedicalRecords save = this.medicalRecordsService.save(medicalRecords);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getMedicalRecords/{id}")
    public ResponseEntity<MedicalRecords> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            MedicalRecords read = this.medicalRecordsService.read(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteMedicalRecords/{id}")
    public ResponseEntity<MedicalRecords> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.medicalRecordsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/medicalRecords")
    public ResponseEntity<Set<MedicalRecords>> getAll()
    {
        Set<MedicalRecords> medicalRecordsSet = this.medicalRecordsService.getAll();
        return ResponseEntity.ok(medicalRecordsSet);
    }
}
