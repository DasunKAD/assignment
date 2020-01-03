package com.noetic.assignment.dao;

import com.noetic.assignment.model.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao {

    int insertEmployee(Employees employees);
    List<Employees> selectAllEmpolyees();
    int deleteEmployeeById(int id);
    int updateEmployeeById(int id,Employees employees);

}
