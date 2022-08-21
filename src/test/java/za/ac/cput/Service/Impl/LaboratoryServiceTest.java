package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.*;
import za.ac.cput.Factory.*;
import za.ac.cput.Repository.ILaboratoryRepository;
import za.ac.cput.Service.Interfaces.ILaboratoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chuma Nxazonke
 * Student number: 219181187
 * Date: 16 August 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LaboratoryServiceTest {


    private ILaboratoryRepository repository;
    private LaboratoryService laboratoryService;


    private Laboratory laboratory;
    private Doctor doctor;
    private Department department;
    private Patient patient;
    private TestPatient testPatient;


    @BeforeEach
    void setUp() {

        this.laboratoryService = new LaboratoryService(repository);
       this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.doctor = DoctorFactory.createDoctor("Chante Davids", "RandomPassword123", department,"Midwife Nurse");
         this.testPatient = TestPatientFactory.createTestPatient("Urine Test");
        this.patient = PatientFactory.createPatient("Azolile Nxumalo","107 Mayday Crescent",765549876,"Male",27,"liveLong@08");
        Laboratory laboratory = FactoryLaboratory.createLaboratory(patient, doctor, testPatient,"Unit 23", "Tuesday", 500);

        assertNotNull(laboratory);
    }

    @Test
    @Order(1)
    void save() {
        Laboratory save = this.repository.save(this.laboratory);
        assertEquals(this.laboratory, save);
    }

    @Test
    @Order(2)
    void read() {
        Laboratory read = this.repository.findById(this.laboratory.getLabID()).orElse(null);
        assertEquals(this.laboratory, read);
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.laboratory.getLabID());
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(0, laboratoryList.size());
    }

    @Test
    @Order(3)
    void getAll() {
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(1, laboratoryList.size());
    }


}
