package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Department;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Factory.DepartmentFactory;
import za.ac.cput.Factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

class IDoctorRepositoryTest {

    private IDoctorRepository repository;
    private Doctor doctor;

    @BeforeEach
    void setUp(){
        Department department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        Doctor doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
        assertNotNull(doctor);
        System.out.println(doctor);
    }

    @Test
    void save(){
        Doctor save = this.repository.save(this.doctor);
        assertEquals(this.doctor,save);
    }

}