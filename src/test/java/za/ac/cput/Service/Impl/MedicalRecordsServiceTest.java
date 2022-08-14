/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Entity.MedicalRecords;
import za.ac.cput.Factory.MedicalRecordsFactory;
import za.ac.cput.Repository.IMedicalRecordsRepository;
import za.ac.cput.Service.Interfaces.IMedicalRecordsService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicalRecordsServiceTest {

    private IMedicalRecordsRepository repository;

    private IMedicalRecordsService service;

    private MedicalRecords medicalRecords;
    @BeforeEach
    void setUp()
    {
        this.service = new MedicalRecordsService(repository);
        this.medicalRecords = MedicalRecordsFactory.createMedicalRecords("22011053"
                ,"Duncan"
                ,96
                ,"Female"
                ,"Negative");
        assertNotNull(medicalRecords);
    }

    @Test
    @Order(1)
    void save()
    {
        MedicalRecords save = this.repository.save(this.medicalRecords);
        assertEquals(this.medicalRecords, save);
    }

    @Test
    @Order(2)
    void read()
    {
        MedicalRecords read = this.repository.getById(this.medicalRecords.getRecordID());
        assertEquals(this.medicalRecords, read);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.medicalRecords.getRecordID());
        List<MedicalRecords> medicalRecordsList = this.repository.findAll();
        assertSame(0, medicalRecordsList.size());
    }

    @Test
    @Order(3)
    void getAll()
    {
        List<MedicalRecords> medicalRecordsList = this.repository.findAll();
        assertSame(1, medicalRecordsList.size());
    }
}