package com.nestdigital.Nestdigital.controller;

import com.nestdigital.Nestdigital.dao.EmployeeDao;
import com.nestdigital.Nestdigital.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path="/addemployee", consumes = "application/json" ,produces = "application/json")
        public String addemployee(@RequestBody EmployeeModel employee){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        employee.setDoj(currentdate);
        System.out.println(employee.toString());
        dao.save(employee);
            return "{status:'success'}";
        }
       @CrossOrigin(origins = "*")
       @Transactional
      @GetMapping(value = "/viewemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> viewall(){
        return (List<EmployeeModel>) dao.findAll();
       }

       @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    public String deleteemployee(@RequestBody EmployeeModel employee){
        dao.deleteById(employee.getId());
        return "{status:'success'}";
       }
   @CrossOrigin(origins = "*")
 @PostMapping(path= "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel>searchemployee(@RequestBody EmployeeModel employee){
        return (List<EmployeeModel>) dao.searchemployee(employee.getName());
   }

   @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editemployee",consumes = "application/json",produces = "application/json")
    public String editemployee(@RequestBody EmployeeModel employee){
        dao.editemployee(employee.getEmail(), employee.getEmpcode(), employee.getName(), employee.getPassword(),employee.getDoj(), employee.getId());
        return "{status:'success'}";
   }
   @CrossOrigin(origins = "*")
    @PostMapping(path="/Employeelogin",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel>login(@RequestBody EmployeeModel employee){
        return(List<EmployeeModel>) dao.login(employee.getEmail(),employee.getPassword());
   }
}
