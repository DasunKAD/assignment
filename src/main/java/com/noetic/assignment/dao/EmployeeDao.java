package com.noetic.assignment.dao;

import com.noetic.assignment.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface EmployeeDao extends JpaRepository<Employees,Integer>{


}
