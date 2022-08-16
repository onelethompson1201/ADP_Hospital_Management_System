package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Factory.FactoryLaboratory;
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


    @BeforeEach
    void setUp() {

        this.laboratoryService = new LaboratoryService(repository);
        this.laboratory = FactoryLaboratory.createLaboratory("Health lab", "On Monday", 100.00);
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
