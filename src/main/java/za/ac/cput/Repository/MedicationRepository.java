package za.ac.cput.Repository;


/* IMedicationRepository.java
 Entity for the IMedicationRepository
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/


import java.util.HashSet;
import java.util.Set;
import za.ac.cput.Entity.Medication;

public interface MedicationRepository extends IRepository
{
    public Set<Medication> getAll();
}