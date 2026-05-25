package com.example.emp.employee_management.service;

import com.example.emp.employee_management.model.Employee;
import com.example.emp.employee_management.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeService()
    {

    }
    @Autowired
    EmployeeRepository rep;
    public void addEmployee(Employee e)
    {
        rep.addEmployee(e);
    }
    public Employee getEmployee(int id)
    {
        return rep.getEmployee(id);
    }
    public List<Employee> getAllEmployee()
    {
        return rep.getAllEmployee();
    }
    public void updateSalary(int id,double sal)
    {
         rep.updateSalary(id,sal);
    }
    public void deleteEmployee(int id)
    {
         rep.deleteEmployee(id);
    }

}
