package com.example.mcv;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import com.example.mcv.Controller.EmployeeController;
import com.example.mcv.Model.Employee;
import com.example.mcv.Service.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(1000.00);

        when(employeeService.findAll()).thenReturn(Arrays.asList(employee));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(view().name("employees"))
                .andExpect(model().attributeExists("employees"))
                .andExpect(model().attribute("employees", hasSize(1)));
    }

    @Test
    public void testAddEmployees() throws Exception {
        mockMvc.perform(get("/addEmployee"))
                .andExpect(status().isOk())
                .andExpect(view().name("addEmployee"))
                .andExpect(model().attributeExists("employee"));
    }

    @Test
    public void testAddEmployeeSubmit() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(1000.00);

        when(employeeService.save(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/addEmployee")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("id", "1")
                    .param("name", "John Doe")
                    .param("salary", "1000.00"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/employees"));
    }
}