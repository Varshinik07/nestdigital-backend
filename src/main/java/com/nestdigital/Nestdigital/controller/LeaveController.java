package com.nestdigital.Nestdigital.controller;

import com.nestdigital.Nestdigital.dao.LeaveDao;
import com.nestdigital.Nestdigital.model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public String addleave(@RequestBody LeaveModel leavetable){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        leavetable.setLeave_applydate(currentdate);
        System.out.println(leavetable.toString());
        dao.save(leavetable);
        return "{status:'success'}";
    }
    @Transactional

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatestatus",consumes = "application/json",produces = "application/json")
    public String updateStatus(@RequestBody LeaveModel leave){
        dao.updateById(leave.getId());
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleaves")
    public List<Map<String ,String>> viewallleaves(){
        return (List<Map<String, String>>) dao.viewAllLeaveBy();

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewleavesbyempid",consumes = "application/json",produces = "application/json")
    public  List<Map<String,String>> viewLeavesById(@RequestBody LeaveModel leave){
        return (List<Map<String, String>>) dao.viewLeaveById(leave.getEmpid());
    }

}
