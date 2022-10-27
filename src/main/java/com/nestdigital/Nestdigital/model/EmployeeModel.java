package com.nestdigital.Nestdigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {
    @Id
    @GeneratedValue
    private int id;
    private int empcode;
    private String name;
    private String email;


    private int password;
    private String doj;

    public EmployeeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public EmployeeModel(int id, int empcode, String name, String email, int password, String doj) {
        this.id = id;
        this.empcode = empcode;
        this.name = name;
        this.email = email;
        this.password = password;
        this.doj = doj;
    }
}
