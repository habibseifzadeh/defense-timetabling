package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.SemesterCommand;
import com.seif.defensetimetabling.converters.SemesterToSemesterCommand;
import com.seif.defensetimetabling.repositories.SemesterRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SemesterJpaService implements SemesterService {

    private SemesterRepository semesterRepository;
    private SemesterToSemesterCommand semesterToSemesterCommand;

    public SemesterJpaService(SemesterRepository semesterRepository, SemesterToSemesterCommand semesterToSemesterCommand) {
        this.semesterRepository = semesterRepository;
        this.semesterToSemesterCommand = semesterToSemesterCommand;
    }

    @Override
    public Set<SemesterCommand> findAll() {

        return StreamSupport.stream(semesterRepository.findAll().spliterator(), false)
                .map(semesterToSemesterCommand::convert).collect(Collectors.toSet());
    }
}
