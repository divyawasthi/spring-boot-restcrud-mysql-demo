package com.springboot.crudrestdemo.dao;

import com.springboot.crudrestdemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    final private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbempl = entityManager.merge(employee);
        return dbempl;
    }

    @Override
    public void deleteById(int id) {
        Employee empl = entityManager.find(Employee.class,id);
        entityManager.remove(empl);
    }
}
