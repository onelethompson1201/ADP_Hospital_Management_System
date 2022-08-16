package za.ac.cput.Service.Impl;


import org.junit.jupiter.api.*;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.TestResultsFactory;
import za.ac.cput.Repository.ITestResultsRepository;
import za.ac.cput.Service.Interfaces.ITestResultsService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestResultsServiceTest {

    private ITestResultsRepository repository;

    private ITestResultsService service;

    private TestResults testResults;
    @BeforeEach
    void setUp()
    {
        this.service = new TestResultsServiceImpl(repository);
        this.testResults = TestResultsFactory.createTestResults("Onele","Female","122005","30 Aug 22","Urine test");
        assertNotNull(testResults);
    }

    @Test
    @Order(1)
    void save()
    {
        TestResults save = this.repository.save(this.testResults);
        assertEquals(this.testResults, save);
    }

    @Test
    @Order(2)
    void read()
    {
        TestResults read = this.repository.getById(this.testResults.getTestID());
        assertEquals(this.testResults, read);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.testResults.getTestID());
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(0, testResultsList.size());
    }

    @Test
    @Order(3)
    void getAll()
    {
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(1, testResultsList.size());
    }
}

