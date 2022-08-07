package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;


import static org.junit.jupiter.api.Assertions.*;

/**
 PatientRepositoryTest.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
 **/

@TestMethodOrder(MethodOrderer.MethodName.class)
class PatientRepositoryTest {
    private static PatientRepository repository = PatientRepository.getRepository();
    private static Patient pat = PatientFactory.createPatient("Monde Masoka", "197 Madayi Street", 78645322,"Male", 21,"Mundah");
    //Patient created = repository.create(pat);

    @Test
    void a_create() {
        Patient created = repository.create(pat);
        assertEquals(pat.getPatientID(), created.getPatientID());
        System.out.println(created.toString());

    }

    @Test
    void b_read() {
        Patient read = repository.read(pat.getPatientID());
        System.out.println(read.toString());
        assertNotNull(read);

    }

    @Test
    void c_update() {
        Patient update =  new Patient.Builder().copy(pat).setPatientName("Monde Shaun Ndongeni").setAddress("197 Madayi Street").setPhone_number(567778682)
                .setSex("Male").setAge(22).setPatientPassword("HeyMundah").build();
        assertNotNull(repository.update(update));
        System.out.println(repository.read(update.getPatientID()));

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(pat.getPatientID());
        assertTrue(success);
        System.out.println(repository.getAll());

    }

    @Test
    void e_getAll() {
        System.out.println(repository.getAll());

    }
}