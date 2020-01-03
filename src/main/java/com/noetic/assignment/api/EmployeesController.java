package com.noetic.assignment.api;

import com.noetic.assignment.model.Employees;
import com.noetic.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/noetic/employee")
@RestController
public class EmployeesController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeesController(EmployeeService employeeService){this.employeeService=employeeService;};
    @PostMapping
    public int addEmployees(@Valid @NotNull @RequestBody Employees employees){
        return employeeService.insertEmployee(employees);
    }
    @GetMapping
    public List<Employees> getAllEmployees(){
        return employeeService.selectAllEmpolyees();
    }
    @DeleteMapping(path = "{id}")
    public int deleteEmployeeById(@PathVariable("id") int id){
        return employeeService.deleteEmployeeById(id);
    }


}
