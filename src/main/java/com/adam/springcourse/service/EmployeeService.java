package com.adam.springcourse.service;

import com.adam.springcourse.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee show(int id);

    void delete(int id);
}
