package com.noetic.assignment.api;

import com.noetic.assignment.model.Employees;
import com.noetic.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/noetic/employee")
@RestController
public class EmployeesController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeesController(EmployeeService employeeService){this.employeeService=employeeService;};
    @PostMapping
    public ResponseEntity<Employees> addEmployees(@Valid @NotNull @RequestBody Employees employees){
        return new ResponseEntity<Employees>(employeeService.insertEmployee(employees), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Employees>> getAllEmployees(){
        return new ResponseEntity<List<Employees>>(employeeService.getAllEmployees(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employees>> getEmployeeByid(@PathVariable(value = "id")int empid){
        Optional<Employees> employees=employeeService.findbyID(empid);
        return new ResponseEntity<Optional<Employees>>(employees,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployeeByid(@PathVariable(value = "id")int empid,@RequestBody Employees
            employees){
        //Exceptions has not been handled
        Employees employee=employeeService.findbyID(empid).get();
        employee.setFname(employees.getFname());
        employee.setLname(employees.getLname());
        employee.setDepartments(employees.getDepartments());
        return new ResponseEntity<Employees>(employeeService.updateEmployees(employee),HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    public void deleteDepartmentByid(@PathVariable(value = "id")int deptId){
        Employees employees=employeeService.findbyID(deptId).get();
        employeeService.deleteEmployeesByid(employees);
    }


}
