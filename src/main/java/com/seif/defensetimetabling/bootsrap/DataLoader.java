package com.seif.defensetimetabling.bootsrap;

import com.seif.defensetimetabling.model.DefensesInterval;
import com.seif.defensetimetabling.model.Semester;
import com.seif.defensetimetabling.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private SemesterRepository semesterRepository;
    private DefensesIntervalRepository defensesIntervalRepository;
    private UnitOfTimeRepository unitOfTimeRepository;
    private PreferencesRepository preferencesRepository;
    private LeaveTimeRepository leaveTimeRepository;
    private ProfessorRepository professorRepository;
    private DefenseSessionRepository defenseSessionRepository;
    private StudentRepository studentRepository;

    public DataLoader(SemesterRepository semesterRepository,
                      DefensesIntervalRepository defensesIntervalRepository,
                      UnitOfTimeRepository unitOfTimeRepository,
                      PreferencesRepository preferencesRepository,
                      LeaveTimeRepository leaveTimeRepository,
                      ProfessorRepository professorRepository,
                      DefenseSessionRepository defenseSessionRepository,
                      StudentRepository studentRepository) {
        this.semesterRepository = semesterRepository;
        this.defensesIntervalRepository = defensesIntervalRepository;
        this.unitOfTimeRepository = unitOfTimeRepository;
        this.preferencesRepository = preferencesRepository;
        this.leaveTimeRepository = leaveTimeRepository;
        this.professorRepository = professorRepository;
        this.defenseSessionRepository = defenseSessionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Semester semester = new Semester();

        semester.setName("971");

        DefensesInterval interval = new DefensesInterval();

        interval.setStartDate(LocalDate.of(2019, 1,1));
        interval.setEndDate((LocalDate.of(2019, 1, 30)));

        interval.addSemester(semester);

        semesterRepository.save(semester);
        defensesIntervalRepository.save(interval);

        log.debug("Data loaded successfully...");
    }
}
