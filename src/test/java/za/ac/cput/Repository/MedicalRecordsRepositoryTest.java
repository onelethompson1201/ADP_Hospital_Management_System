/* MediclRecordsRepositoryTest.java
   Repository Test for the MedicalRecords
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Factory.MedicalRecordsFactory;


@TestMethodOrder(MethodOrderer.Alphanumeric.class) //jUnit5 @TestMethodOrder(MethodOrderer.MethodName.class)
public class MedicalRecordsRepositoryTest 
{
   private static MedicalRecordsRepository repository = MedicalRecordsRepository.getRepository();
   private static MedicalRecords medicalRecords = MedicalRecordsFactory.createMedicalRecords(
           "0102", "Duncan", 29, "Male", "Positive for Aids");
    
   @Test
   void a_create()
   {
       MedicalRecords created = repository.create(medicalRecords);
       assertEquals(medicalRecords.getRecordID(), created.getRecordID());
       System.out.println("Create: " +created);
   }
   
   @Test
   void b_read()
   {
       MedicalRecords read = repository.read(medicalRecords.getRecordID());
       assertNotNull(read);
       System.out.println("Read: "+read.toString());
   }
   
   @Test 
   void c_update()
   {
       MedicalRecords updated = new MedicalRecords.Builder().copy(medicalRecords).setPatientID("0103")
               .setPatientName("Sam")
               .setPatientAge(22)
               .setPatientSex("Female")
               .setTestResults("Negative for Aids")
               .build();
       assertNotNull(repository.update(updated));
       System.out.println("Updated: "+updated);
   }
   
   @Test
   void e_delete()
   {
       boolean success = repository.delete(medicalRecords.getRecordID());
       assertTrue(success);
       System.out.println("Deleted: "+success);
   }
   
   @Test
   void d_getAll()
   {
       System.out.println("Show all:");
       System.out.println(repository.getAll());
   }
}

