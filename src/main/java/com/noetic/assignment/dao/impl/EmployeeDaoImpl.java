package com.noetic.assignment.dao.impl;

import com.noetic.assignment.dao.EmployeeDao;
import com.noetic.assignment.model.Employees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("h2Dao")
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public int insertEmployee(Employees employees) {
        return 0;
    }

    @Override
    public List<Employees> selectAllEmpolyees() {
        return null;
    }

    @Override
    public int deleteEmployeeById(int id) {
        return 0;
    }

    @Override
    public int updateEmployeeById(int id, Employees employees) {
        return 0;
    }
}
