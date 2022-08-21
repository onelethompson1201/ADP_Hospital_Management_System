package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.FactoryLaboratory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *
 *
 */

class FactoryLaboratoryTest {

    @Test
    public void test() {
        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test");
        Patient patient = PatientFactory.createPatient("Azolile Nxumalo","107 Mayday Crescent",765549876,"Male",27,"liveLong@08");
        Laboratory laboratory = FactoryLaboratory.createLaboratory(patient, doctor, testPatient,"Unit 23", "Tuesday", 500);

        System.out.println(laboratory.toString());
        assertNotNull(laboratory);

    }

}

