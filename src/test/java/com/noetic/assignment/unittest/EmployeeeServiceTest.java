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
        Mockito.when(employeeDao.selectAllEmpolyees()).thenReturn(Stream.of(new Employees(1,"dasun","madhuwantha",
                new Departments(1,"IT")),new Employees(2,"sahan","harithapriya",
                new Departments(1,"IT"))).collect(Collectors.toList()));
        Assert.assertEquals(2,employeeService.selectAllEmpolyees().size() );

    }
}
