/*
DoctorServiceTest
Name: Chante Lee Davids
Student number: 220246688
Date: 13 August 2022
 */

package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;
import za.ac.cput.Repository.IDoctorRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DoctorServiceTest {

    private IDoctorRepository repository;
    private DoctorService service;

    private Doctor doctor;
    private Department department;

    @BeforeEach
    void setUp(){
        this.service = new DoctorService(repository);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        assertNotNull(doctor);
    }

    @Test
    @Order(1)
    void save() {
        Doctor save = this.repository.save(this.doctor);
        assertEquals(this.doctor, save);
    }

    @Test
    @Order(2)
    void read() {
        Doctor read = this.repository.findById(this.doctor.getDoctorID()).orElse(null);
        assertEquals(this.doctor, read);
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
        boolean success = service.delete(this.doctor.getDoctorID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }
}