package com.adam.springcourse.dao;

import com.adam.springcourse.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void save(Employee employee);

    Employee show(int id);

    void delete(int id);
}
