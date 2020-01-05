package com.noetic.assignment.service;

import com.noetic.assignment.dao.DepartmentDao;
import com.noetic.assignment.model.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao){this.departmentDao=departmentDao;};

    public Departments insertDepartments(Departments departments) {
        return departmentDao.save(departments);
    }

    public List<Departments> getAllDepartments(){
        return departmentDao.findAll();
    }
    public Optional<Departments> findbyID(int deptId){
        return departmentDao.findById(deptId);
    }
    public  Departments updateDepartment(Departments departments){
        return departmentDao.save(departments);

    }
    public  void  deleteDepartmentByid(Departments departments){
        departmentDao.delete(departments);

    }
}
