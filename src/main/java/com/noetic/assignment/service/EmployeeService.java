package com.noetic.assignment.service;

import com.noetic.assignment.dao.DepartmentDao;
import com.noetic.assignment.dao.EmployeeDao;
import com.noetic.assignment.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService  {

    private  EmployeeDao employeeDao;
    @Autowired
    public EmployeeService(EmployeeDao employeeDao){this.employeeDao=employeeDao;};

    public Employees insertEmployee(Employees employees) {
        return employeeDao.save(employees);
    }
    public List<Employees> getAllEmployees() {
        return employeeDao.findAll();
    }
    public Optional<Employees> findbyID(int deptId){
        return employeeDao.findById(deptId);
    }
    public  Employees updateEmployees(Employees employees){
        return employeeDao.save(employees);

    }
    public  void  deleteEmployeesByid(Employees employees){
        employeeDao.delete(employees);

    }
}
