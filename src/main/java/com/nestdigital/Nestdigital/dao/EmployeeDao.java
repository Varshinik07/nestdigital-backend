package com.nestdigital.Nestdigital.dao;

import com.nestdigital.Nestdigital.model.EmployeeModel;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `id`= :id",nativeQuery = true)
    void deleteById(Integer id);

   @Query(value = "SELECT `id`, `email`, `empcode`, `name`, `password` ,'doj' FROM `employee` WHERE `name`= :name",nativeQuery = true)
    List<EmployeeModel>searchemployee(String name);

   @Modifying
  @Query(value = "UPDATE `employee` SET `email`= :email,`empcode`= :empcode,`name`= :name ,`password`= :password,`doj`= :doj WHERE `id`= :id",nativeQuery = true)
    void editemployee(String email,Integer empcode,String name,Integer password,String doj,Integer id);


    @Query(value = "SELECT `id`, `email`, `empcode`, `name`, `password`, `doj` FROM `employee` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<EmployeeModel>login(String email,Integer password);
}
