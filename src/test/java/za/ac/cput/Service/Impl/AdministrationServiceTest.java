package za.ac.cput.Service.Impl;
/*
    Author: Duncan Benjamin Harris
    Student Number: 220110530
    14/08/2022
*/
import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;
import za.ac.cput.Repository.IAdministrationRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdministrationServiceTest {

    private IAdministrationRepository repository;

    private AdministrationService service;

    private Administration administration;

    @BeforeEach
    void setUp()
    {
        this.service = new AdministrationService(repository);
        this.administration = AdministrationFactory.createAdministration("Duncan"
                ,"password");
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
        Set<Administration> administrationSet = this.repository.findAll().stream().collect(Collectors.toSet());
        assertSame(0, administrationSet.size());
    }

    @Test
    @Order(3)
    void getAll()
    {
        Set<Administration> administrationSet = this.repository.findAll().stream().collect(Collectors.toSet());
        assertSame(1, administrationSet.size());
    }
}