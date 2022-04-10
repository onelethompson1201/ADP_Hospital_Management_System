/*  DoctorRepositoryTest.java
    Test for the DoctorRepository
    Author: Chante Lee Davids [220246688]
    Date  : 8 April 2022
*/

package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Doctor;
import za.ac.cput.Factory.DoctorFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DoctorRepositoryTest {
    private static DoctorRepository repository = DoctorRepository.getRepository();
    private static Doctor doctor = DoctorFactory.createDoctor("Demi Greene",
                                                            "VeryCoolPassword_123",
                                                            "Nursing Department",
                                                            "Midwife Nurse");

    @Test
    void a_create(){
        Doctor created = repository.create(doctor);
        assertEquals(doctor.getDoctorID(),created.getDoctorID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        Doctor read = repository.read(doctor.getDoctorID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }
    @Test
    void c_update(){
        Doctor updated = new Doctor.Builder().copy(doctor)
                .setDoctorName("Demi Davids")
                .setDoctorPassword("KitKat_42")
                .setDepartmentName("Nursing Department")
                .setSpecialty("Pediatric Nurse")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }
    @Test
    void e_delete(){
        boolean success = repository.delete(doctor.getDoctorID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);

    }
    @Test
    void d_getAll(){
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}