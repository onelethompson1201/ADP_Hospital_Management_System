/* IMedicalRecordsRepository.java
   Interface for the MedicalRecordsRepository(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.MedicalRecords;

public interface IMedicalRecordsRepository extends JpaRepository<MedicalRecords, String>
{

}
