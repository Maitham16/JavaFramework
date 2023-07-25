package com.example.mcv.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.example.mcv.Model.Employee;
import com.example.mcv.Service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }


    @PostMapping("/addEmployee")
    public String addEmployeeSubmit(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }
}
