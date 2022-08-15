package za.ac.cput.Repository;

/* ITestResultsRepositoryTest.java
 Test for ITestResultsRepository
 Author: Onele Tomson (219483280)
*/

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Entity.TestResults;

import za.ac.cput.Factory.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITestResultsRepositoryTest {

    private ITestResultsRepository repository;
    private TestResults testResults;

    @BeforeEach
    void setUp(){

        TestResults testResults = TestResultsFactory.createTestResults("Onele Tomson","F","122001","29 Aug 2022","Estimate of when the baby will be delivered");
        Department department = DepartmentFactory.createDepartment("Women", "Labour", 20);
        Doctor doctor = DoctorFactory.createDoctor("Onele", "Tom2001", department,"Child Birth");
        TestPatient testPatient = TestPatientFactory.createTestPatient("Delivery Date Test");
        assertNotNull(testResults);
        System.out.println(testResults);
    }

    @Test
    @Order(1)
    void save(){
        TestResults save = this.repository.save(this.testResults);
        assertEquals(this.testResults,save);
    }

    @Test
    @Order(2)
    void read() {
        TestResults read = this.repository.getById(this.testResults.getTestID());
    }



    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.testResults.getTestID());
        List<TestResults> testResultsList = this.repository.findAll();
        assertSame(0, testResultsList.size());
    }

}
