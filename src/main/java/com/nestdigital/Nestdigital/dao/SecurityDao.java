package com.nestdigital.Nestdigital.dao;

import com.nestdigital.Nestdigital.model.EmployeeModel;
import com.nestdigital.Nestdigital.model.SecurityModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `id`= :id",nativeQuery = true)
    void deleteById(Integer id);
    @Query(value = "SELECT `id`, `doj`, `name`, `password`, `securitycode`, `username` FROM `security` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<SecurityModel>login(String username,String password);

}
