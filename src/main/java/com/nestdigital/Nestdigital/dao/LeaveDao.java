package com.nestdigital.Nestdigital.dao;

import com.nestdigital.Nestdigital.model.LeaveModel;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {
}
