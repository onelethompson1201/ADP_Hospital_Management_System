package za.ac.cput.Factory;

/* TestResultsFactoryTest.java
 Entity for the TestResultsFactoryTest
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.TestResultsFactory;


public class TestResultsFactoryTest {

    @Test
    void createTestResults()
    {
        TestResults testResults = TestResultsFactory.createTestResults("Onele", "Female", "122001", "08 May 2022", "Blood Test");
        assertNotNull(testResults);
        System.out.println(testResults);
    }
}