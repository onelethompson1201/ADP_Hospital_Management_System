/*  IDepartmentRepositoryTest.java
    Test for IDepartmentRepository
    Author: Chante Lee Davids [220246688]
    Date  : 8 August 2022
*/

package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

class IDepartmentRepositoryTest {

    private IDepartmentRepository repository;
    private Department department;

    @BeforeEach
    void setUp(){
        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        assertNotNull(department);
        System.out.println(department);
    }

    @Test
    void save(){
        Department save = this.repository.save(this.department);
        assertEquals(this.department,save);
    }
}