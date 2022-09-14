package za.ac.cput.Controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Service.Impl.TestResultsServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/hospital-management/testResults/")
@Slf4j
public class TestResultsController {

    private TestResultsServiceImpl testResultsServiceImpl;

    @Autowired
    TestResultsController(TestResultsServiceImpl testResultsServiceImpl)
    {
        this.testResultsServiceImpl = testResultsServiceImpl;
    }

    @PostMapping("save/testResults")
    public ResponseEntity<TestResults> save(@Valid @RequestBody TestResults testResults)
    {
        log.info("Save Request: {}", testResults);
        TestResults save = this.testResultsServiceImpl.save(testResults);
        return ResponseEntity.ok(save);
    }
    @GetMapping("getTestResults/{id}")
    public ResponseEntity<TestResults> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            TestResults read = this.testResultsServiceImpl.read(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteTestResults/{id}")
    public ResponseEntity<TestResults> delete(@PathVariable String id)
    {
        log.info("Delete Request: {}", id);
        this.testResultsServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getTestResults/testResults")
    public ResponseEntity<List<TestResults>> getAll(){
        List<TestResults> testResultsList =  this.testResultsServiceImpl.getTestResults();
        return ResponseEntity.ok(testResultsList);
    }
}

