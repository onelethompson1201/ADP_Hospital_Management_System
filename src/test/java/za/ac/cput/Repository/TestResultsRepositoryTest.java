package za.ac.cput.Repository;

/* TestResultsRepositoryTest.java
 Entity for the TestResultsRepositoryTest
 Author: Onele Tomson (219483280)
 Date: 08 May 2022
*/



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Entity.TestResults;
import za.ac.cput.Factory.TestResultsFactory
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestResultsRepositoryTest
{
    private static TestResultsRepository repository = TestResultsRepository.getRepository();
    private static TestResults testresults = TestResultsFactory.createTestResults(
            "Onele", "Female", 122001, "08 May 2022", "Blood Test");

    @Test
    void a_create()
    {
        TestResults created = repository.create(TestResults);
        assertEquals(TestResults.getTestResultsID(), created.getTestResultsID());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read()
    {
        TestResults read = repository.read(TestResults.getTestResultsID());
        assertNotNull(read);
        System.out.println("Read: "+read);
    }

    @Test
    void c_update()
    {
        TestResults updated = new TestResults.Builder().copy(TestResults).setTestResultsID("122001")
                .setpatientName("Onele")
                .setpatientSex("female")
                .settestDate("8 May 2022")
                .settestDescription("Blood Test")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(TestResults.getTestResultsID());
        assertTrue(success);
        System.out.println("Deleted: "+success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}
