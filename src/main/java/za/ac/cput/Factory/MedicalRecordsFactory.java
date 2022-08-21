/* MedicalRecordsFactory.java
   Factory for the MedicalsRecords(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Factory;

import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.util.Helper;
import za.ac.cput.util.StringHelper;


public class MedicalRecordsFactory 
{
    public static MedicalRecords createMedicalRecords(
            TestResults testResults)
    {
        String recordID = Helper.generateRecordID();

        StringHelper.checkStringParam("recordID",recordID);

        MedicalRecords medicalRecords = new MedicalRecords.Builder().setRecordID(recordID)
                .setTestResults(testResults).build();
        
        return medicalRecords;
        
    }
}

