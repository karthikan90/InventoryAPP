package com.acs.interview.integration;

import com.acs.interview.BaseIT;
import com.acs.interview.response.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeControllerIT extends BaseIT {

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(String.valueOf(port)).concat("/employee");
    }

    @Test
    public void testGetEmployeeById() {
        final String url = baseUrl + "/{id}";
        final ResponseEntity<Employee> response = testRestTemplate.getForEntity(url, Employee.class,1);
         final Employee employee =  response.getBody();

        assertNotNull(employee);
        assertEquals(1,employee.getId());
        assertEquals("Mohan", employee.getName());
    }
}
