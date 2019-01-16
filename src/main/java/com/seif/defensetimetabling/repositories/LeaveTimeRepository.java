package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.LeaveTime;
import org.springframework.data.repository.CrudRepository;

public interface LeaveTimeRepository extends CrudRepository<LeaveTime, Long> {
}
