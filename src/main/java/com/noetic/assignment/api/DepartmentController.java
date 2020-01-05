package com.noetic.assignment.api;

import com.noetic.assignment.model.Departments;
import com.noetic.assignment.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/noetic/departments")
@RestController
public class DepartmentController {
    private  final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }
    @PostMapping
    public ResponseEntity<Departments> addnewDepartment(@RequestBody Departments departments){
       return new ResponseEntity<Departments>(departmentService.insertDepartments(departments), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List< Departments >> getAllEmployees() {
        return new ResponseEntity<List<Departments>>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Departments>> getDepartmentByid(@PathVariable(value = "id")int deptId){
        Optional<Departments> departments=departmentService.findbyID(deptId);
        return new ResponseEntity<Optional<Departments>>(departments,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departments> updateDepartmentByid(@PathVariable(value = "id")int deptId,@RequestBody
            Departments
            departments){
        //Exceptions has not been handled
        Departments department=departmentService.findbyID(deptId).get();
        department.setDeptName(departments.getDeptName());
       return  new ResponseEntity<Departments>(departmentService.updateDepartment(department),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartmentByid(@PathVariable(value = "id")int deptId){
        Departments department=departmentService.findbyID(deptId).get();
         departmentService.deleteDepartmentByid(department);
    }
}
