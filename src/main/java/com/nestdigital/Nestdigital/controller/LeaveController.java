package com.nestdigital.Nestdigital.controller;

import com.nestdigital.Nestdigital.dao.LeaveDao;
import com.nestdigital.Nestdigital.model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

}
