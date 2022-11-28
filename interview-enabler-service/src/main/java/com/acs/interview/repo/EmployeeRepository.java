package com.acs.interview.repo;

import com.acs.interview.response.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {
    private static final Map<Integer, Employee> employees = new HashMap<>();

    static {
        employees.put(1, Employee.builder().id(1).name("Mohan").build());
        employees.put(2, Employee.builder().id(2).name("Shwee").build());
    }
    
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    
    public Employee getEmployeeById(final Integer id) {
        return employees.get(id);
    }

    
    public String delete(final Integer id) {
        return employees.remove(id) == null ? "Employee Id does not exist!" : "Successfully deleted the employees";
    }

    
    public Employee update(final Integer id, final Employee employee) {
        if(employees.containsKey(id)) {
            return employees.put(id, employee);
        }
        return null;
    }

    
    public Employee save(Employee employee) {
        return employees.put(employee.getId(), employee);
    }
}
