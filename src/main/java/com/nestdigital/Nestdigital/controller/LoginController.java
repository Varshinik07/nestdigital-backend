package com.nestdigital.Nestdigital.controller;

import com.nestdigital.Nestdigital.dao.LoginDao;
import com.nestdigital.Nestdigital.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
@RestController
public class LoginController {




        @Autowired
        private LoginDao dao;
        @CrossOrigin(origins = "*")
        @PostMapping(path = "/addlog",consumes = "application/json",produces = "application/json")
        public String addLog(@RequestBody LoginModel l){
            DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            String currentdate=String.valueOf(dt.format(now));
            l.setInDate(currentdate);
            dao.save(l);
            return "{status:'success'}";
        }
        @CrossOrigin(origins = "*")
        @Transactional
        @PostMapping(path = "/logout",consumes = "application/json",produces = "application/json")
        public String logOutStatus(@RequestBody LoginModel l){
            DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            String currentdate=String.valueOf(dt.format(now));
            l.setOutDate(currentdate);
            dao.logOutStatus(l.getCheckOut(),l.getOutDate(),l.getEmpId());
            return "{status:success}";
        }
        @CrossOrigin(origins = "*")
        @GetMapping("/viewalllogs")
        public List<Map<String,String>> viewAllLog(){
            return (List<Map<String, String>>) dao.viewAllLogBy();
        }
        @CrossOrigin(origins = "*")
        @PostMapping(path = "/viewlogbyid",consumes = "application/json",produces = "application/json")
        public List<Map<String,String>> viewLogByEmp(@RequestBody LoginModel l){
            return (List<Map<String, String>>) dao.viewlogByEmpid(l.getEmpId());
        }


    }

