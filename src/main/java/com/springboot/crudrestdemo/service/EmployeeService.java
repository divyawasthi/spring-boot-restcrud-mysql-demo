package com.springboot.crudrestdemo.service;

import com.springboot.crudrestdemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findall();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
