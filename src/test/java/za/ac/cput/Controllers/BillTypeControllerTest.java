package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.Entity.Bill;
import za.ac.cput.Factory.BillFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BillTypeControllerTest {

    @LocalServerPort private int port;
    @Autowired private BillTypeController controller;
    @Autowired TestRestTemplate restTemplate;
    private Bill bill;
    private final String baseURL = "http://localhost:8080/hospital-management/bill-type/";
    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        this.bill = BillFactory.createBill("99034", "435", "Davin"
                ,716172619);
        String url = baseURL;
    }

    @Test
    void save() {
        String url = baseURL + "save";
        //System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody()));
    }

    @Test
    void read() {
        String billNo = "99034";
        String url = baseURL + "read" + billNo;
        //System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
    }


}