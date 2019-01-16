package com.seif.defensetimetabling.bootsrap;

import com.seif.defensetimetabling.model.*;
import com.seif.defensetimetabling.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        loadTimes();
        loadProfessorsAndStudents();
        loadDefenseSessions();
    }

    private void loadDefenseSessions() {

        DefensesInterval defensesInterval = semesterRepository
                .findByName("971").get().getDefensesIntervals().iterator().next();
        UnitOfTime defenseUnitOfTime = unitOfTimeRepository
                .findByDescriptionAndDefensesInterval("8-9:30", defensesInterval).get();

        Student yaghoubi = studentRepository.findByLastNameAndFirstName("yaghoubi", "razieh").get();

        Professor nadimi = professorRepository.findByLastNameAndFirstName("nadimi", "mohammad").get();
        Professor seifzadeh = professorRepository.findByLastNameAndFirstName("seifzadeh", "habib").get();
        Professor naderi = professorRepository.findByLastNameAndFirstName("naderi", "mohammad").get();
        Professor fekri = professorRepository.findByLastNameAndFirstName("fekri", "shervan").get();

        DefenseSession defenseSession = new DefenseSession();
        defenseSession.setDate(LocalDate.of(2019, 1, 14));

        defenseSession.addStudent(yaghoubi);
        defenseSession.setTitle("Use text mining to suggest reviewers for a defense session");
        defenseSession.addSupervisor(seifzadeh);
        defenseSession.addExternalReviewer(naderi);
        defenseSession.addInternalReviewer(nadimi);
        defenseSession.addCoordinator(fekri);
        defenseSession.addUnitOfTime(defenseUnitOfTime);

        defenseSessionRepository.save(defenseSession);

        log.debug("defense sessions loaded successfully...");
    }

    private void loadProfessorsAndStudents() {

        DefensesInterval defensesInterval = semesterRepository
                .findByName("971").get().getDefensesIntervals().iterator().next();
        UnitOfTime leaveUnitOfTimeForProfessor1 = unitOfTimeRepository
                .findByDescriptionAndDefensesInterval("8-9:30", defensesInterval).get();

        Professor seifzadeh = new Professor();
        seifzadeh.setFirstName("habib");
        seifzadeh.setLastName("seifzadeh");
        LeaveTime leaveTime = new LeaveTime();
        leaveTime.setUnitOfTime(leaveUnitOfTimeForProfessor1);
        leaveTime.setDate(LocalDate.of(2019, 1, 15));

        Professor naderi = new Professor();
        Preferences preferences = new Preferences();
        preferences.setDefensesInterval(defensesInterval);
        preferences.setDesiredNumberOfCoordination(0);
        preferences.setDesiredNumberOfReview(3);
        naderi.setFirstName("mohammad");
        naderi.setLastName("naderi");
        naderi.addPreferences(preferences);

        Professor nadimi = new Professor();
        nadimi.setFirstName("mohammad");
        nadimi.setLastName("nadimi");

        Professor fekri = new Professor();
        fekri.setFirstName("shervan");
        fekri.setLastName("fekri");


        Student yaghoubi = new Student();
        yaghoubi.setFirstName("razieh");
        yaghoubi.setLastName("yaghoubi");

        seifzadeh.addLeaveTime(leaveTime);

        preferencesRepository.save(preferences);
        professorRepository.save(seifzadeh);
        professorRepository.save(naderi);
        professorRepository.save(fekri);
        professorRepository.save(nadimi);
        leaveTimeRepository.save(leaveTime);
        studentRepository.save(yaghoubi);

        log.debug("professors loaded successfully...");

    }

    private void loadTimes() {
        Semester semester = new Semester();
        semester.setName("971");

        DefensesInterval interval = new DefensesInterval();
        interval.setStartDate(LocalDate.of(2019, 1,1));
        interval.setEndDate((LocalDate.of(2019, 1, 30)));

        UnitOfTime firstTime = new UnitOfTime();
        firstTime.setDescription("8-9:30");

        UnitOfTime secondTime = new UnitOfTime();
        secondTime.setDescription("9:30-11");

        UnitOfTime thirdTime = new UnitOfTime();
        thirdTime.setDescription("11-12:30");

        UnitOfTime fourthTime = new UnitOfTime();
        fourthTime.setDescription("13-14:30");

        UnitOfTime fifthTime = new UnitOfTime();
        fifthTime.setDescription("14:30-16");

        UnitOfTime sixthTime = new UnitOfTime();
        sixthTime.setDescription("16-17:30");

        interval.addSemester(semester);
        interval.addUnitOfTime(firstTime);
        interval.addUnitOfTime(secondTime);
        interval.addUnitOfTime(thirdTime);
        interval.addUnitOfTime(fourthTime);
        interval.addUnitOfTime(fifthTime);
        interval.addUnitOfTime(sixthTime);

        semesterRepository.save(semester);
        defensesIntervalRepository.save(interval);
        unitOfTimeRepository.save(firstTime);
        unitOfTimeRepository.save(secondTime);
        unitOfTimeRepository.save(thirdTime);
        unitOfTimeRepository.save(fourthTime);
        unitOfTimeRepository.save(fifthTime);
        unitOfTimeRepository.save(sixthTime);

        log.debug("semesters and intervals loaded successfully...");
    }
}
