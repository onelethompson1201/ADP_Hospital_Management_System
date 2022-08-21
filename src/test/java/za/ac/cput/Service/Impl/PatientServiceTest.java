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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PatientServiceTest {
    @Autowired
    private PatientService service;

    private static Patient patient1 = PatientFactory.createPatient("Zolile Zuma", "110 Long Island Road", +786520098, "Male", 34, "PassWord009@");
    private static Patient patient2 = PatientFactory.createPatient("Wendy William", "245 Clifton Road", +819086543, "Male", 38, "Pass@Word087");
    private static Patient patient3 = PatientFactory.createPatient("Jason Rent", "01 Gorven Street", +865208098, "Male", 21, "pa$sWoRd@221");
    private static Patient patient4 = PatientFactory.createPatient("Christine Zondi", "45 Wellington Street", +620086798, "Female", 56, "PA$sworD!028");
    private static Patient patient5 = PatientFactory.createPatient("Nondumiso Maxoki", "27 Nomyayi Street", +715204098, "Female", 37, "useRnAMe!98765");


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

        Patient read = service.read(patient2.getPatientID());
        assertEquals(read.getPatientID(), patient2.getPatientID());
        System.out.println("Read: " + read);
    }

    /*@Test
    void getPatientByName() {
        Patient read = this.repository.findByName(this.patient.getPatientName());
        assertEquals(this.patient, read);
    }*/

    @Test
    void d_delete() {
       boolean success = service.delete(patient1.getPatientID());
       assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void c_getPatients(){
        System.out.println("Get all patients: ");
        System.out.println(service.getPatients());

    }
}