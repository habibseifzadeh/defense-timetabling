package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.DefensesInterval;
import com.seif.defensetimetabling.model.UnitOfTime;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfTimeRepository extends CrudRepository<UnitOfTime, Long> {

    Optional<UnitOfTime> findByDescriptionAndDefensesInterval(String description, DefensesInterval interval);
}
