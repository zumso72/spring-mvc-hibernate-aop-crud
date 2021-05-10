package com.adam.springcourse.controllers;

import com.adam.springcourse.entity.Employee;
import com.adam.springcourse.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class MyController {
    private final EmployeeService employeeService;

    @Autowired
    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping()
    public String index(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee){
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "new";
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("{id}/edit")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        Employee employee = employeeService.show(id);
        model.addAttribute("employee", employee);
        return "new";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") int id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
