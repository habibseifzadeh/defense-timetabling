package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Optional<Professor> findByLastNameAndFirstName(String lastName, String firstName);
}
