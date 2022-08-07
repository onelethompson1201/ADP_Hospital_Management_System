package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class IAdministrationRepositoryTest {

    private IAdministrationRepository repository;

    private Administration administration;

    @BeforeEach
    void setUp()
    {
        this.administration = AdministrationFactory.createAdministration("Duncan",
                "password");
        assertNotNull(administration);
    }

    @Test
    @Order(1)
    void save()
    {
        Administration save = this.repository.save(this.administration);
        assertEquals(this.administration, save);
    }

    @Test
    @Order(2)
    void read()
    {
        Administration read = this.repository.getById(this.administration.getAdminID());
        assertEquals(this.administration, read);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.administration.getAdminID());
        List<Administration> administrationList = this.repository.findAll();
        assertSame(0, administrationList.size());
    }

    @Test
    @Order(3)
    void findAll()
    {
        List<Administration> administrationList = this.repository.findAll();
        assertSame(1, administrationList.size());
    }
}