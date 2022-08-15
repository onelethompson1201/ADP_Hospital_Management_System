/* TestResultsFactory.java
 Factory for TestResults
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

package za.ac.cput.Factory;

import za.ac.cput.Entity.TestResults;
import za.ac.cput.util.Helper;


public class TestResultsFactory {

    public static TestResults createTestResults(String patientName,String patientSex, String testID, String testDate, String testDescription)
    {
        testID = Helper.generateTestID();
        TestResults testresults = new TestResults.Builder()
                .setPatientName(patientName)
                .setPatientSex(patientSex)
                .setTestID(testID)
                .setTestDate(testDate)
                .setTestDescription(testDescription)
                .build();
        return testresults;
    }
}