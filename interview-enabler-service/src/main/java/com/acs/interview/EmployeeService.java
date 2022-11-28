package com.acs.interview;

import com.acs.interview.response.Employee;

import java.util.Collection;

public interface EmployeeService {
    Collection<Employee> getEmployees();

    Employee getEmployeeById(final Integer id);

    String delete(final Integer id);

    Employee update(final Integer id, final Employee employee);

    Employee save(final Employee employee);

}
