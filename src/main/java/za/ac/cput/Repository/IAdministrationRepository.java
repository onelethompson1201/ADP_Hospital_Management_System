/* IAdministrationRepository.java
   Interface for the administrationRepository(220110530)
   Author: Duncan Benjamin Harris
   Date: 08 April 2022 
*/
package za.ac.cput.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Administration;

@Repository
public interface IAdministrationRepository extends JpaRepository<Administration, String>
{

}
