/*  DepartmentFactoryTest.java
    Test for the DepartmentFactory
    Author: Chante Lee Davids [220246688]
    Date  : 6 April 2022
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Test
    void createDepartment() {

        Department department = DepartmentFactory.createDepartment("Nursing Department", 145);
        assertNotNull(department);
        System.out.println(department);

    }
}