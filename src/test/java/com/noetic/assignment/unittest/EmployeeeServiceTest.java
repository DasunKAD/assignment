package com.noetic.assignment.unittest;

import com.noetic.assignment.dao.EmployeeDao;
import com.noetic.assignment.model.Departments;
import com.noetic.assignment.model.Employees;
import com.noetic.assignment.service.EmployeeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeeServiceTest {
    @Mock
    private EmployeeService employeeService;
    @MockBean
    private EmployeeDao employeeDao;

    @Test
    public void getAllEmployeesTest(){
        Mockito.when(employeeDao.findAll()).thenReturn(Stream.of(new Employees(3,"imhi","koshala",
                new Departments(1,"department1")),new Employees(6,"dasu","Madhuwantha",
                new Departments(2,"department2"))).collect(Collectors.toList()));
        Assert.assertEquals(2,employeeService.getAllEmployees().size() );

    }
}
