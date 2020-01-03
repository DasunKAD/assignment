package com.noetic.assignment.service;

import com.noetic.assignment.dao.EmployeeDao;
import com.noetic.assignment.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService  {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(@Qualifier("h2Dao")EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }

    public int insertEmployee(Employees employees) {
        return employeeDao.insertEmployee(employees);
    }
    public List<Employees> selectAllEmpolyees() {
        return employeeDao.selectAllEmpolyees();
    }
    public int deleteEmployeeById(int id) {
        return employeeDao.deleteEmployeeById(id);
    }
    public int updateEmployeeById(int id, Employees employees) {
        return employeeDao.updateEmployeeById(id,employees);
    }
}
