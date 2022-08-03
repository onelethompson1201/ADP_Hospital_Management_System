package za.ac.cput.Repository;

//This class I will test this entity using the specified method.
//This is a RepositoryLaboratoryTest.Java


import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import za.ac.cput.Entity.Laboratory;
import za.ac.cput.Factory.FactoryLaboratory;


import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Chuma Edward Nxazonke
 * Student number: 219181187
 * Date: 09 April 2022
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class RepositoryLaboratoryTest {


    private static LaboratoryRepository repository = LaboratoryRepository.getRepository();
    private static Laboratory laboratory = FactoryLaboratory.createLaboratory(
            "Blood testing lab",
            "On monday at 3pm",
            120.20);


    @Test
    void a_create() {
        Laboratory created = repository.create(laboratory);
        assertEquals(created.getLabID(), laboratory.getLabID());
        System.out.println("Laboratory card has been created successfully: " + created);
    }


    @Test
    void b_read() {
        Laboratory read = repository.read(laboratory.getLabID());
        assertNotNull(repository);
        System.out.println("Read: " + read);

    }


    @Test
    void c_update() {
        Laboratory updateLaboratory = new Laboratory.Builder().Copy(laboratory)
                .setLabName("Science laboratory")
                .setLabDay("On Thursday at 1pm afternoon")
                .build();
        assertEquals(updateLaboratory.getLabID(), laboratory.getLabID());
        System.out.println("Laboratory card has been updated successfully: " + updateLaboratory);
    }


    @Test
    void d_delete() {
        repository.delete(laboratory.getLabID());
      assertNotNull(repository);
        System.out.println("Laboratory card has been removed successfully");
    }


    @Test
    void getAll() {
        System.out.println("Laboratory card: \n" + repository.getAll());


    }
}


