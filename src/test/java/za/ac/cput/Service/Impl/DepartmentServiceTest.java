/*
DepartmentServiceTest
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Repository.IDepartmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentServiceTest {

    private IDepartmentRepository repository;
    private DepartmentService service;

    private Department department;

    @BeforeEach
    void setUp(){
        this.service = new DepartmentService(repository);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        assertNotNull(department);

    }

    @Test
    @Order(1)
    void save() {
        Department save = this.repository.save(this.department);
        assertEquals(this.department, save);
    }

    @Test
    @Order(2)
    void read() {
        Department read = this.repository.findById(this.department.getDepartmentID()).orElse(null);
        assertEquals(this.department, read);
    }

    @Test
    @Order(3)
    void getAll() {
        System.out.println("Get All: ");
        System.out.println(service.getAll());
    }

    @Test
    @Order(4)
    void delete() {
        boolean success = service.delete(this.department.getDepartmentID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }
}