package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByLastNameAndFirstName(String lastName, String firstName);
}
