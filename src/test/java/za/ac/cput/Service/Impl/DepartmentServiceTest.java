/*
DepartmentServiceTest
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Repository.IDepartmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentServiceTest {

    private final Department department = DepartmentFactory.createDepartment(
            "NU",
            "Nursing Unit",
            50);

    @Autowired
    private DepartmentService service;

    @Test
    @Order(1)
    void save() {
        System.out.println("Created: ");
        Department save = service.save(department);
        assertNotNull(department);
        System.out.println(save);
    }

    @Test
    @Order(2)
    void read() {
        Department read = service.read(department.getDepartmentID());
        assertEquals(read.getDepartmentID(), department.getDepartmentID());
        System.out.println("Read: " + read);
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
        boolean success = service.delete(department.getDepartmentID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }
}