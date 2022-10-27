package com.nestdigital.Nestdigital.controller;

import com.nestdigital.Nestdigital.dao.SecurityDao;;
import com.nestdigital.Nestdigital.model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public String addsecurity(@RequestBody SecurityModel security){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        security.setDoj(currentdate);
        System.out.println(security.toString());
        dao.save(security);
        return "{{status:'success'}}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecurity")
    public List<SecurityModel>viewsecurity(){
        return (List<SecurityModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    public String delete(@RequestBody SecurityModel security){
        dao.deleteById(security.getId());
        return "{{status:'success'}}";

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/securitylogin",consumes = "application/json",produces = "application/json")
    public List<SecurityModel>login(@RequestBody SecurityModel security){
        return(List<SecurityModel>) dao.login(security.getUsername(), security.getPassword());
    }
}
