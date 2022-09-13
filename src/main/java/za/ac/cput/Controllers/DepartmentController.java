package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Department;
import za.ac.cput.Service.Impl.DepartmentService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/department/")
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping("save/department")
    public ResponseEntity<Department> save(@Valid @RequestBody Department saveDepartment)
    {
        log.info("Save request: {}", saveDepartment);

        try{
            Department department = this.departmentService.save(saveDepartment);
            return  ResponseEntity.ok(department);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readDepartment/{departmentID}")
    public ResponseEntity<Department> read(@PathVariable String departmentID){
        log.info("Read request: {}", departmentID);

        try{
            Department read = this.departmentService.read(departmentID);
            return ResponseEntity.ok(read);
        }
        catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("deleteDepartment/{departmentID}")
    public ResponseEntity<Department> delete(@PathVariable String departmentID)   {
        log.info("Delete request: {}", departmentID);
        this.departmentService.delete(departmentID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/department")
    public ResponseEntity<Set<Department>> getAll(){
        Set<Department> departmentSet = this.departmentService.getAll();
        return ResponseEntity.ok(departmentSet);
    }

}
