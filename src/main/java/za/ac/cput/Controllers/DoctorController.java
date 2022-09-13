package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Service.Impl.DoctorService;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/doctor/")
@Slf4j
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping("save/doctor")
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor saveDoctor)
    {
        log.info("Save request: {}", saveDoctor);

        try{
            Doctor doctor = this.doctorService.save(saveDoctor);
            return  ResponseEntity.ok(doctor);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readDoctor/{doctorID}")
    public ResponseEntity<Doctor> read(@PathVariable String doctorID){
        log.info("Read request: {}", doctorID);

        try{
            Doctor read = this.doctorService.read(doctorID);
            return ResponseEntity.ok(read);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("deleteDoctor/{doctorID}")
    public ResponseEntity<Doctor> delete(@PathVariable String doctorID)   {
        log.info("Delete request: {}", doctorID);
        this.doctorService.delete(doctorID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/doctor")
    public ResponseEntity<Set<Doctor>> getAll(){
        Set<Doctor> doctorSet = this.doctorService.getAll();
        return ResponseEntity.ok(doctorSet);
    }
}
