package com.acs.interview.impl;

import com.acs.interview.EmployeeService;
import com.acs.interview.repo.EmployeeRepository;
import com.acs.interview.response.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN)
//Sure-fire plugin is required to run unit test cases
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void getEmployeesTest() {
        //Mock
        when(employeeRepository.getEmployees()).thenReturn(getMockEmployees());

        //Actual Call
        Collection<Employee> employees = employeeService.getEmployees();

        //Assertion
        assertThat(employees).isNotEmpty();
        assertThat(employees.size()).isEqualTo(1);

        //Verification
        verify(employeeRepository).getEmployees();
    }

    @Test
    public void getEmployeeByIdTest() {
        //Mock
        when(employeeRepository.getEmployeeById(1)).thenReturn(getEmployee());

        //Actual Call
        Employee employee = employeeService.getEmployeeById(1);

        //Assertion
        assertThat(employee).isNotNull();
        assertThat(getEmployee()).isEqualTo(employee);

        //Verification
        verify(employeeRepository).getEmployeeById(1);
    }

    @Test
    public void saveEmployeeTest() {
        //Mock
        Employee employee = getEmployee();
        when(employeeRepository.save(employee)).thenReturn(employee);

        //Actual Call
        Employee savedEmployee = employeeService.save(employee);

        //Assertion
        assertThat(savedEmployee).isNotNull();
        assertThat(employee).isEqualTo(savedEmployee);

        //Verification
        verify(employeeRepository).save(employee);
    }

    private Collection<Employee> getMockEmployees() {
        return List.of(getEmployee());
    }

    private Employee getEmployee() {
        return Employee.builder().id(1).name("John Doe").build();
    }
}
