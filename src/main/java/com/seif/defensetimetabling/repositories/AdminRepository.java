package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Optional<Admin> findByLastNameAndFirstName(String lastName, String firstName);
}
