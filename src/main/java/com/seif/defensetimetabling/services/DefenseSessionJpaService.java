package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.DefenseSessionCommand;
import com.seif.defensetimetabling.converters.DefenseSessionToDefenseSessionCommand;
import com.seif.defensetimetabling.repositories.DefenseSessionRepository;

import java.util.HashSet;
import java.util.Set;

public class DefenseSessionJpaService implements DefenseSessionService {

    private DefenseSessionRepository defenseSessionRepository;
    private DefenseSessionToDefenseSessionCommand defenseSessionToDefenseSessionCommand;

    public DefenseSessionJpaService(DefenseSessionRepository defenseSessionRepository,
                                    DefenseSessionToDefenseSessionCommand defenseSessionToDefenseSessionCommand) {
        this.defenseSessionRepository = defenseSessionRepository;
        this.defenseSessionToDefenseSessionCommand = defenseSessionToDefenseSessionCommand;
    }

    @Override
    public Set<DefenseSessionCommand> findAll() {
        Set<DefenseSessionCommand> result = new HashSet<>();
        defenseSessionRepository.findAll().forEach(
                e -> result.add(defenseSessionToDefenseSessionCommand.convert(e)));
        return result;
    }
}
