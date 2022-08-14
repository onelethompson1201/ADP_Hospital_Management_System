package za.ac.cput.Repository;
/* IReceptionistRepository.java
   Repository Class: IReceptionistRepository(220021333)
   Author: Davin Shaun Carstens
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
