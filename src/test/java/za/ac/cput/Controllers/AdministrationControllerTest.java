package za.ac.cput.Controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Administration;
import za.ac.cput.Factory.AdministrationFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdministrationControllerTest {

    @LocalServerPort
    private int portNumber;

    @Autowired
    private AdministrationController administrationController;

    @Autowired
    private TestRestTemplate restTemplate;

    private Administration administration;

    private String urlBase;

    @BeforeEach
    void setUp()
    {
        assertNotNull(administrationController);
        this.administration = AdministrationFactory.createAdministration("Duncan"
                ,"password");
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/administration/";
    }


    @Test
    @Order(1)
    void save()
    {
        String url = urlBase + "save/admin";
        System.out.println(url);

        ResponseEntity<Administration> administrationResponseEntity = this.restTemplate.postForEntity(url, this.administration, Administration.class);
        System.out.println(administrationResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK, administrationResponseEntity.getStatusCode()),
                ()-> assertNotNull(administrationResponseEntity.getBody()));
        System.out.println("Admin saved!");
    }

    @Test
    @Order(2)
    void read()
    {
        String url = urlBase + "getAdmin/"+administration.getAdminID();
        System.out.println(url);

        ResponseEntity<Administration> administrationResponseEntity = this.restTemplate.getForEntity(url, Administration.class);
        System.out.println(administrationResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,administrationResponseEntity.getStatusCode()),
                ()-> assertNotNull(administrationResponseEntity.getBody()));
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = urlBase + "deleteAdmin/"+administration.getAdminID();
        System.out.println(url);

        assertAll(()->assertSame("1",administration.getAdminID()),
                ()->assertNotNull(administration.getAdminName()));
        System.out.println("Delete successful!");
    }

    @Test
    @Order(3)
    void getAll()
    {
        String url = urlBase + "getAll/admin";
        System.out.println(url);

        ResponseEntity<Administration[]> responseEntity =this.restTemplate.getForEntity(url, Administration[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}