package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Preferences;
import org.springframework.data.repository.CrudRepository;

public interface PreferencesRepository extends CrudRepository<Preferences, Long> {
}
