package com.acs.interview.api;

import com.acs.interview.response.Employee;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequestMapping("/employee")
public interface EmployeeController {
    @ApiOperation(value = "View a list of available employees", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping
    ResponseEntity<Collection<Employee>> get();

    @ApiOperation(value = "View a employee by id", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Employee by Id"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/{id}")
    ResponseEntity<Employee> getById(@PathVariable final Integer id);

    @ApiOperation(value = "To save the employees", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully Created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping
    ResponseEntity<Employee> save(@RequestBody final Employee employee);
}
