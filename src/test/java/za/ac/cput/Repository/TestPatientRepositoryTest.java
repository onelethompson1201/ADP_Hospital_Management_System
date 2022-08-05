package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.TestPatientFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;
/**
TestPatientRepositoryTest.Java
 AUTHOR: Nolubabalo Ndongeni
 Student number: 219319464
 Date: 10 April 2022
**/
@TestMethodOrder(MethodOrderer.MethodName.class)

class TestPatientRepositoryTest {
    private static TestPatientRepository repository = TestPatientRepository.getRepository();
    private static TestPatient test = TestPatientFactory.createTestPatient("DNA");
    //TestPatient created = repository.create(test);



    @Test
    void a_create() {
        TestPatient created = repository.create(test);
        assertSame(test.getTestID(),created.getTestID());

    }

    @Test
    void b_read() {
        TestPatient read = repository.read(test.getTestID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        TestPatient update = new TestPatient.Builder().copy(test).setTestName("Blood Test").setPatientID(Helper.generatePatientID()).build();
        assertNotNull(repository.update(update));
        System.out.println(repository.getAll());

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(test.getTestID());
        assertTrue(success);
        System.out.println(repository.getAll());

    }
    @Test
    void d_getAll() {
        System.out.println(repository.getAll());
    }

}