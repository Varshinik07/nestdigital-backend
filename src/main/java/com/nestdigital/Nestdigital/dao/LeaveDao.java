package com.nestdigital.Nestdigital.dao;

import com.nestdigital.Nestdigital.model.LeaveModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Map;
public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
    @Modifying
    @Query(value = "UPDATE `leave` SET  WHERE `id`= :id",nativeQuery = true)
    void updateById(Integer id);

    @Query(value = "SELECT `id`, l.`empid`, l.`leave_applydate`, l.`leave_duratiom`, l.`leave_reason`,l.`leave_requireddate`, l.`name`,e.name FROM `leavetable`  l JOIN employee e ON l.empid=e.empcode",nativeQuery = true)
    List<Map<String,String>>viewAllLeaveBy();

    @Query(value = "SELECT `id`, l.`empid`, l.`leave_applydate`, l.`leave_duratiom`, l.`leave_reason`,l.`leave_requireddate`, l.`name`,e.name FROM `leavetable`  l JOIN employee e ON l.empid=e.empcode WHERE l.empid:empid",nativeQuery = true)
    List<Map<String,String>>viewLeaveById(Integer emp_id);
}
