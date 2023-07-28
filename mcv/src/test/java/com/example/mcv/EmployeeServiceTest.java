package com.example.mcv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.mcv.Model.Employee;
import com.example.mcv.Repository.EmployeeRepository;
import com.example.mcv.Service.EmployeeService;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAll() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(1000.00);

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        Iterable<Employee> result = employeeService.findAll();

        Employee resultEmployee = result.iterator().next();
        assertEquals(employee.getId(), resultEmployee.getId());
        assertEquals(employee.getName(), resultEmployee.getName());
        assertEquals(employee.getSalary(), resultEmployee.getSalary(), 0);
    }

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(1000.00);

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee result = employeeService.save(employee);

        assertEquals(employee.getId(), result.getId());
        assertEquals(employee.getName(), result.getName());
        assertEquals(employee.getSalary(), result.getSalary(), 0);
    }
}
