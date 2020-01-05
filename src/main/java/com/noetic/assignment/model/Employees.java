package com.noetic.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="employees")
public class Employees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;
    private  String fname;
    private String lname;
    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "departments_id",nullable = false)
    private Departments departments;

    public Employees(){};

    public Employees(
                     @JsonProperty("fname")@NotBlank String fname,
                     @JsonProperty("lname")@NotBlank String lname,
                     @JsonProperty("departments")@NotBlank Departments departments
            ) {
        this.fname = fname;
        this.lname = lname;
//        this.departments.setEmployees(this);
        this.departments=departments;
    }
    public Employees(
            int emp_id,
            String fname,
            String lname,
            Departments departments) {
        this.emp_id=emp_id;
        this.fname = fname;
        this.lname = lname;
        this.departments = departments;
        this.departments.setEmployees(this);
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
                ", departments=" + departments +
                '}';
    }

    @JsonIgnore
    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
}
