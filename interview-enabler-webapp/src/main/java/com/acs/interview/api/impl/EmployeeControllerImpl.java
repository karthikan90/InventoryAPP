package com.acs.interview.api.impl;

import com.acs.interview.EmployeeService;
import com.acs.interview.api.EmployeeController;
import com.acs.interview.response.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Collection<Employee>> get() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @Override
    public ResponseEntity<Employee> getById(@PathVariable final Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @Override
    public ResponseEntity<Employee> save(@RequestBody final Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }
}
