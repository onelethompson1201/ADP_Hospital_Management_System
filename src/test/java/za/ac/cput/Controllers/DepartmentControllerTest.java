package za.ac.cput.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Department;
import za.ac.cput.Factory.DepartmentFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentControllerTest {

    @LocalServerPort
    private int portNumber;
    @Autowired private DepartmentController departmentController;
    @Autowired private TestRestTemplate restTemplate;
    private Department department;
    private String urlBase;


    @BeforeEach
    void setUp() {
        //assertNotNull(departmentController);
        this.department = DepartmentFactory.createDepartment("NU", "Nursing Unit", 50);
        this.urlBase = "http://localhost:" + this.portNumber + "/hospital-management/department/";
    }

    @Test
    void a_save() {
        String url = urlBase + "save";
        System.out.println(url);

        ResponseEntity<Department> departmentResponseEntity = this.restTemplate
                .postForEntity(url, this.department, Department.class);
        System.out.println(departmentResponseEntity);

        assertAll(
                ()-> assertEquals(HttpStatus.OK, departmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(departmentResponseEntity.getBody())
        );
    }

    @Test
    void b_read() {
        String url = urlBase + "readDepartment/" + department.getDepartmentID();
        System.out.println(url);

        ResponseEntity<Department> departmentResponseEntity = this.restTemplate.getForEntity(url, Department.class);
        System.out.println(departmentResponseEntity);

        assertAll(()-> assertEquals(HttpStatus.OK,departmentResponseEntity.getStatusCode()),
                ()-> assertNotNull(departmentResponseEntity.getBody()));
    }

    @Test
    void d_delete() {
        String url = urlBase + "deleteDepartment/" + this.department.getDepartmentID();
        this.restTemplate.delete(url);

//        assertAll(()->assertSame("1",department.getDepartmentID()),
//                ()-> assertNotNull(department.getDepartmentName()));

//        assertNull(department.getDepartmentName());
//        System.out.println("Delete successful!");

    }

    @Test
    void e_getAll() {
        String url = urlBase + "getDepartments";
        System.out.println(url);

        ResponseEntity<Department[]> responseEntity =this.restTemplate.getForEntity(url, Department[].class);
        System.out.println(Arrays.asList((Objects.requireNonNull(responseEntity.getBody()))));

        assertAll(()-> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                ()-> assertTrue(responseEntity.getBody().length == 0),
                ()-> assertNotNull(responseEntity));
    }
}