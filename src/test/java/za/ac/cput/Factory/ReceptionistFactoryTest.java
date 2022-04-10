/* ReceptionFactoryTest.java
   Test class for ReceptionistFactory
   Author: Davin Shaun Carstens
   Date: 08 April 2022
*/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Receptionist;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistFactoryTest
{
    @Test
    void createReceptionist()
    {
        Receptionist receptionist = ReceptionistFactory.createReceptionist("213", "davin", 23345);
        assertNotNull(receptionist);
        System.out.println(receptionist);
    }
}