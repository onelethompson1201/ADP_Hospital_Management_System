package za.ac.cput.Repository;
/* IReceptionistRepository.java
   Entity for the IReceptionistRepository(220021333)
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Receptionist;

import java.util.Set;
@Repository
public interface IReceptionistRepository extends JpaRepository<Receptionist, String>
{
    public Set<Receptionist> getAll();
}
