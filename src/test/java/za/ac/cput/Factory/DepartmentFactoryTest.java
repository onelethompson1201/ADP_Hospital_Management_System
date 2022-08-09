/*  DepartmentFactoryTest.java
    Test for the DepartmentFactory
    Author: Chante Lee Davids [220246688]
    Date  : 6 August 2022
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentFactoryTest {

    @Test
    void createDepartment() {

        Department department = DepartmentFactory.createDepartment("NU","Nursing Unit", 50);
        assertNotNull(department);
        System.out.println(department);
    }
}