package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Factory.FactoryLaboratory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Chuma Nxazonke
 *  Student Number: 219181187
 *  Date: 17 July 2022
 *  This is an updated version
 */

class ILaboratoryRepositoryTest {

    private ILaboratoryRepository repository;
    private Laboratory laboratory;

    @BeforeEach
    void setUp(){

Laboratory laboratory = FactoryLaboratory.createLaboratory("Medical lab","Monday", 200);
        assertNotNull(laboratory);
        System.out.println(laboratory);
    }

    @Test
    @Order(1)
    void save(){
        Laboratory save = this.repository.save(this.laboratory);
        assertEquals(this.laboratory,save);
    }

    @Test
    @Order(2)
    void read() {
        Laboratory read = this.repository.getById(this.laboratory.getDoctorId());
    }

    @Test
    @Order(3)
    void findAll() {
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(1, laboratoryList.size());
    }

    @Test
    @Order(4)
    void delete() {
        this.repository.deleteById(this.laboratory.getDoctorId());
        List<Laboratory> laboratoryList = this.repository.findAll();
        assertSame(0, laboratoryList.size());
    }

}