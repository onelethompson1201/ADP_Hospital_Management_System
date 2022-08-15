package za.ac.cput.Factory;

/* MedicationFactoryTest.java
 Entity for the MedicationFactoryTest
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Medication;


public class MedicationFactoryTest
{
    @Test
    void createMedication() {
    }
    Medication medication = MedicationFactory.createMedication
            ("122001","Adcodol",125F,5);
   // assertNotNull(medication);
   // System.out.println(medication);
}

