package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Factory.FactoryLaboratory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 *
 */

class FactoryLaboratoryTest {

    @Test
    public void test() {
        Laboratory laboratory = FactoryLaboratory.createLaboratory(
                "Science lab",
                "Monday at 2pm",
                85.54);
        System.out.println(laboratory.toString());
        assertNotNull(laboratory);

    }

}

