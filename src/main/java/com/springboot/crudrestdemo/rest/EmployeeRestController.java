package com.springboot.crudrestdemo.rest;

import com.springboot.crudrestdemo.dao.EmployeeDAO;
import com.springboot.crudrestdemo.entity.Employee;
import com.springboot.crudrestdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findall();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee empl =  employeeService.findById(id);
        if (empl==null) throw new RuntimeException("Employee not found - " + id);
        return empl;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee empl = employeeService.save(employee);
        return empl;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee empl = employeeService.findById(id);
        if (empl == null) throw new RuntimeException("Employee id not found - "+ id);
        employeeService.deleteById(id);
        return "Deleted employee id - " + id;
    }
}
