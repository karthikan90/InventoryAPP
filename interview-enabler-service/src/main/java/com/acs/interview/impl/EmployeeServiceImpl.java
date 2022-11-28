package com.acs.interview.impl;

import com.acs.interview.EmployeeService;
import com.acs.interview.repo.EmployeeRepository;
import com.acs.interview.response.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Collection<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    public Employee getEmployeeById(final Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public String delete(final Integer id) {
        return employeeRepository.delete(id);
    }

    @Override
    public Employee update(final Integer id, final Employee employee) {
        return employeeRepository.update(id, employee);
    }

    @Override
    public Employee save(final Employee employee) {
        return employeeRepository.save(employee);
    }

}
