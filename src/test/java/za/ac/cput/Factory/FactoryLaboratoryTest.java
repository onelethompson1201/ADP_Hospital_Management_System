package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.*;

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

        Laboratory laboratory = FactoryLaboratory.createLaboratory("Mrs James", "Dr Nxazonke", "Positive","Unit 23", "Tuesday", 500);

        System.out.println(laboratory.toString());
        assertNotNull(laboratory);

    }

}

