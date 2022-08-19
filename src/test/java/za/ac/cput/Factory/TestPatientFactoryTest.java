package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;

import static org.junit.jupiter.api.Assertions.*;

class TestPatientFactoryTest {

    @Test
    void createTestPatient() {

            Patient patient = PatientFactory.createPatient("Nolubabalo Ndongeni","60 Longmarket Street", 67367872,"Female",23, "Hey@Healthy001" );
            TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test", patient);
            assertNotNull(testPatient);
            System.out.println(testPatient);


    }
}