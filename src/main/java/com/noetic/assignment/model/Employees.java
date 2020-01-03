package com.noetic.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="employees")
public class Employees {
    @Id
    private int emp_id;
    @NotBlank
    private  String fname;
    @NotBlank
    private String lname;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "departments_id",nullable = false)
    private Departments departments;

    public Employees(@JsonProperty("id") int emp_id,
                     @JsonProperty("fname")@NotBlank String fname,
                     @JsonProperty("lname")@NotBlank String lname,
                     @JsonProperty("department")Departments
            departments) {
        this.emp_id = emp_id;
        this.fname = fname;
        this.lname = lname;
        this.departments = departments;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "emp_id=" + emp_id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", departments=" + departments.getDeptId() +
                '}';
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
