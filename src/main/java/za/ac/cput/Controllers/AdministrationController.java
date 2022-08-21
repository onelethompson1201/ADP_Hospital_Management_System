/*
        Author: Duncan Benjamin Harris
        Student Number: 220110530
        21/08/2022
*/


package za.ac.cput.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Service.Impl.AdministrationService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/administration/")
@Slf4j
public class AdministrationController
{
    private AdministrationService administrationService;

    @Autowired
    AdministrationController(AdministrationService administrationService)
    {
        this.administrationService = administrationService;
    }

    @PostMapping("save/admin")
    public ResponseEntity<Administration> save(@Valid @RequestBody Administration administration)
    {
        log.info("Save Request: {}", administration);
        Administration save = this.administrationService.save(administration);
        return ResponseEntity.ok(save);
    }

    @GetMapping("getAdmin/{id}")
    public ResponseEntity<Administration> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Administration read = this.administrationService.read(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteAdmin/{id}")
    public ResponseEntity<Administration> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.administrationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll/admin")
    public ResponseEntity<Set<Administration>> getAll()
    {
        Set<Administration> administrationSet = this.administrationService.getAll();
        return ResponseEntity.ok(administrationSet);
    }
}
