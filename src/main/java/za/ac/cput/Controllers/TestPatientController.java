package za.ac.cput.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Service.Impl.PatientService;
import za.ac.cput.Service.Impl.TestPatientService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/administration/")
@Slf4j
public class TestPatientController {
    private TestPatientService testPatientService;

    @Autowired
    TestPatientController(TestPatientService testPatientService){
        this.testPatientService = testPatientService;
    }

    @PostMapping("save/testPatient")
    public ResponseEntity<TestPatient> save(@Valid @RequestBody TestPatient testPatient)
    {
        log.info("Save request: {}", testPatient);
        TestPatient save = this.testPatientService.save(testPatient);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getTestPatient/{id}")
    public ResponseEntity<TestPatient> read(@PathVariable String id){
        log.info("Read request: {}", id);
        try{
            TestPatient read = this.testPatientService.read(id);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteTestPatient/{id}")
    public ResponseEntity<Patient> delete(@PathVariable String id)   {
        log.info("Delete request:", id);
        this.testPatientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getTestPatients/testPatient")
    public ResponseEntity<Set<TestPatient>> getAll(){
        Set<TestPatient> testPatientsSet = (Set<TestPatient>) this.testPatientService.getTestPatients();
        return ResponseEntity.ok(testPatientsSet);
    }
}
