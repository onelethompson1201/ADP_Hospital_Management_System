/*  DoctorFactoryTest.java
    Test for the DoctorFactory
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Doctor;

import static org.junit.jupiter.api.Assertions.*;

class DoctorFactoryTest {

    @Test
    void createDoctor() {

        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "KitKat_42","Nursing Department","Midwife Nurse");
        assertNotNull(doctor);
        System.out.println(doctor);

    }
}