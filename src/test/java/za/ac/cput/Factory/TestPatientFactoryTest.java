package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.TestPatient;

import static org.junit.jupiter.api.Assertions.*;

class TestPatientFactoryTest {

    @Test
    void createTestPatient() {

            TestPatient testPatient = TestPatientFactory.createTestPatient("Urine Test");
            assertNotNull(testPatient);
            System.out.println(testPatient);


    }
}