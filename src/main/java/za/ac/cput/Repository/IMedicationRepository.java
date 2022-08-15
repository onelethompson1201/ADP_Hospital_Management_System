package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Medication;


public interface IMedicationRepository extends JpaRepository<Medication, String>
{

}
