/*  IDepartmentRepositoryTest.java
    Test for IDepartmentRepository
    Author: Chante Lee Davids [220246688]
    Date  : 8 August 2022
*/

package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(1)
    void save(){
        Department save = this.repository.save(this.department);
        assertEquals(this.department,save);
    }

    @Test
    @Order(2)
    void read() {
        Department read = this.repository.getById(this.department.getDepartmentID());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Department> departmentList = this.repository.findAll();
        assertSame(1, departmentList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.department.getDepartmentID());
        List<Department> departmentList = this.repository.findAll();
        assertSame(0, departmentList.size());
    }
}