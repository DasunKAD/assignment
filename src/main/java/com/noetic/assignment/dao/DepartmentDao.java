package com.noetic.assignment.dao;

import com.noetic.assignment.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Departments,Integer>{
}
