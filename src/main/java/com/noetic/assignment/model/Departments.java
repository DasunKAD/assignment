package com.noetic.assignment.model;

import javax.persistence.*;

@Entity
@Table(name="departments")
public class Departments  {
    @Id
    private int deptId;
    private String deptName;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "departments")
    private Employees employees;

    public Departments(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
