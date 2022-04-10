package za.ac.cput.Factory;

import za.ac.cput.Entity.TestPatient;
import za.ac.cput.util.Helper;
/**
 TestPatientFactory.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/

public class TestPatientFactory {
    public static TestPatient createTestPatient(String testName){
        String testID = Helper.generateTestID();
        String patientID = Helper.generatePatientID();

        TestPatient testPatient = new TestPatient.Builder().setTestID(testID).setTestName(testName).setPatientID(patientID).build();
        return testPatient;
    }
}
