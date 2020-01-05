package com.noetic.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="departments")
public class Departments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    @NotBlank
    @Column(name="deptName")
    private String deptName;
    @OneToOne(mappedBy = "departments",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Employees employees;

    public Departments() {

    }
    public Departments(int deptId ) {
        this.deptId=deptId;
    }

    public Departments( String deptName) {
        this.deptName = deptName;
    }

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
                ", employees=" + employees +
                '}';
    }
}
