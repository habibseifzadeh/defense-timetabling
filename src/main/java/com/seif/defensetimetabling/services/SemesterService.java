package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.SemesterCommand;

import java.util.Set;

public interface SemesterService {

    Set<SemesterCommand> findAll();
}
