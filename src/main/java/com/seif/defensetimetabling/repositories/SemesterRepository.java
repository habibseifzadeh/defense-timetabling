package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Semester;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SemesterRepository extends CrudRepository<Semester, Long> {

    Optional<Semester> findByName(String name);
}
