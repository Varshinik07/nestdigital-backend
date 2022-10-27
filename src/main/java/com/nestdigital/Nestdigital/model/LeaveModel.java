package com.nestdigital.Nestdigital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leavetable")
public class LeaveModel {

    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String name;
    private String leave_requireddate;
    private String leave_reason;
    private String leave_duratiom;
    private String leave_applydate;

    public LeaveModel(int id, int empid, String name, String leave_requireddate, String leave_reason, String leave_duratiom, String leave_applydate) {
        this.id = id;
        this.empid = empid;
        this.name = name;
        this.leave_requireddate = leave_requireddate;
        this.leave_reason = leave_reason;
        this.leave_duratiom = leave_duratiom;
        this.leave_applydate = leave_applydate;
    }

    public LeaveModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeave_requireddate() {
        return leave_requireddate;
    }

    public void setLeave_requireddate(String leave_requireddate) {
        this.leave_requireddate = leave_requireddate;
    }

    public String getLeave_reason() {
        return leave_reason;
    }

    public void setLeave_reason(String leave_reason) {
        this.leave_reason = leave_reason;
    }

    public String getLeave_duratiom() {
        return leave_duratiom;
    }

    public void setLeave_duratiom(String leave_duratiom) {
        this.leave_duratiom = leave_duratiom;
    }

    public String getLeave_applydate() {
        return leave_applydate;
    }

    public void setLeave_applydate(String leave_applydate) {
        this.leave_applydate = leave_applydate;
    }
}
