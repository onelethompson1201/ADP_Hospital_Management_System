/* MedicalRecordsFactory.java
   Factory for the MedicalsRecords(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Factory;

import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;

public class MedicalRecordsFactory 
{
    public static MedicalRecords createMedicalRecords(
                                                    String  patientID,
                                                    String patientName,
                                                    int patientAge,
                                                    String patientSex,
                                                    String testResults)
    {
        String recordID = Helper.generateRecordID();

        StringHelper.checkStringParam("recordID",recordID);
        StringHelper.checkStringParam("patientID",patientID);
        StringHelper.checkStringParam("patientName",patientName);
        StringHelper.checkStringParam("patientAge", String.valueOf(patientAge));
        StringHelper.checkStringParam("patientSex",patientSex);
        StringHelper.checkStringParam("testResults",testResults);

        MedicalRecords medicalRecords = new MedicalRecords.Builder().setRecordID(recordID).
                setPatientID(patientID).
                setPatientName(patientName).
                setPatientAge(patientAge).
                setPatientSex(patientSex).
                setTestResults(testResults).build();
        
        return medicalRecords;
        
    }
}

