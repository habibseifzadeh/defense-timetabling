package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.DefenseSessionCommand;

import java.util.Set;

public interface DefenseSessionService {

    Set<DefenseSessionCommand> findAll();
}
