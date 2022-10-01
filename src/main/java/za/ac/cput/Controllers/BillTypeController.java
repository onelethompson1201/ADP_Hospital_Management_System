package za.ac.cput.Controllers;
/* BillTypeController.java
   Controller Class: BillController(220021333)
   Author: Davin Shaun Carstens
*/
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Service.Impl.BillServiceImpl;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/hospital-management/bill-type/")
@Slf4j
public class BillTypeController {

    private BillServiceImpl billService;

    @Autowired
    public BillTypeController(BillServiceImpl billService) {
        this.billService = billService;
    }

    @PostMapping("save")
    public ResponseEntity<Bill> save(@Valid @RequestBody Bill bill){
        log.info("Save Request: {}", bill);
        Bill save = this.billService.save(bill);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read")
    public ResponseEntity<Bill> read(@PathVariable String id){
        log.info("Read request: {}", id);
        try{
            Bill read = this.billService.read(id);
            return ResponseEntity.ok(read);
        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<Bill> delete(@PathVariable String id){
        log.info("Delete Request: {}", id);
        this.billService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll")
    public ResponseEntity<Set<Bill>> getAll(){
        Set<Bill> billSet = this.billService.getAll();
        return ResponseEntity.ok(billSet);
    }
}
