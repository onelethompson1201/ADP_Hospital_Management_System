package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Service.Impl.PatientService;



import static org.junit.jupiter.api.Assertions.*;

/*
PatientServiceTest
Name: Nolubabalo Ndongeni
Student number: 219319464
Date: 14 August 2022
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PatientServiceTest {
    @Autowired
    private PatientService service;

    private final Patient patient1 = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    private final Patient patient2 = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    private static Patient patient3 = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    private static Patient patient4 = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");
    private static Patient patient5 = PatientFactory.createPatient( "Babsie Ndongeni", "67 Nomyayi Street", +785648934,"Female",22,"password");


    @Test
    void a_save() {
        System.out.println("Created: ");
        Patient created1 = service.save(patient1);
        assertNotNull(created1);
        System.out.println(created1);

        System.out.println("Created: ");
        Patient created2 = service.save(patient2);
        assertNotNull(created2);
        System.out.println(created2);

        System.out.println("Created: ");
        Patient created3 = service.save(patient3);
        assertNotNull(created3);
        System.out.println(created3);

        System.out.println("Created: ");
        Patient created4 = service.save(patient4);
        assertNotNull(created4);
        System.out.println(created4);

        System.out.println("Created: ");
        Patient created5 = service.save(patient5);
        assertNotNull(created1);
        System.out.println(created5);
    }


    @Test
    void b_read() {
        Patient read = service.read(patient4.getPatientID());
        assertNotNull(read.getPatientID(), patient4.getPatientID());
        System.out.println("Read: " + read);
    }

    /*@Test
    void getPatientByName() {
        Patient read = this.repository.findByName(this.patient.getPatientName());
        assertEquals(this.patient, read);
    }*/

    @Test
    void d_delete() {
        service.delete(patient3.getPatientID());
        assertNotNull(patient3);
        System.out.println("Deleted: " + patient3);
    }

    @Test
    void c_getPatients(){
        System.out.println("Get all patients: ");
        System.out.println(service.findAll());

    }
}