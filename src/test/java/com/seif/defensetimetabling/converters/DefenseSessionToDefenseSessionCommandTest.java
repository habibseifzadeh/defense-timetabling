package com.seif.defensetimetabling.converters;

import com.seif.defensetimetabling.commands.DefenseSessionCommand;
import com.seif.defensetimetabling.model.DefenseSession;
import com.seif.defensetimetabling.model.Professor;
import com.seif.defensetimetabling.model.Student;
import com.seif.defensetimetabling.model.UnitOfTime;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class DefenseSessionToDefenseSessionCommandTest {

    DefenseSessionToDefenseSessionCommand defenseSessionToDefenseSessionCommand;

    @Before
    public void setUp() {
        defenseSessionToDefenseSessionCommand = new DefenseSessionToDefenseSessionCommand();
    }

    @Test
    public void testNormalDefense() {
        //given
        DefenseSession defenseSession = new DefenseSession();
        defenseSession.setTitle("this is a title");
        Professor professor1 = new Professor();
        professor1.setFirstName("habib");
        professor1.setLastName("seifzadeh");
        defenseSession.setSupervisor(professor1);
        defenseSession.setAdvisor(professor1);
        defenseSession.setCoordinator(professor1);
        defenseSession.setInternalReviewer(professor1);
        defenseSession.setExternalReviewer(professor1);
        Student student1 = new Student();
        student1.setFirstName("razieh");
        student1.setLastName("yaghoubi");
        defenseSession.setStudent(student1);
        defenseSession.setDate(LocalDate.now());
        UnitOfTime unitOfTime = new UnitOfTime();
        unitOfTime.setDescription("8-9:30");
        defenseSession.setUnitOfTime(unitOfTime);

        DefenseSessionCommand expectedResult = new DefenseSessionCommand();
        expectedResult.setAdvisorFirstName("habib");
        expectedResult.setAdvisorLastName("seifzadeh");
        expectedResult.setSupervisorFirstName("habib");
        expectedResult.setSupervisorLastName("seifzadeh");
        expectedResult.setExternalReviewerFirstName("habib");
        expectedResult.setExternalReviewerLastName("seifzadeh");
        expectedResult.setInternalReviewerFirstName("habib");
        expectedResult.setInternalReviewerLastName("seifzadeh");
        expectedResult.setCoordinatorFirstName("habib");
        expectedResult.setCoordinatorLastName("seifzadeh");
        expectedResult.setStudentFirstName("razieh");
        expectedResult.setStudentLastName("yaghoubi");
        expectedResult.setTime("8-9:30");
        expectedResult.setDate(LocalDate.now());
        expectedResult.setTitle("this is a title");

        //when
        DefenseSessionCommand actualResult = defenseSessionToDefenseSessionCommand.convert(defenseSession);

        //then
        assertEquals(expectedResult, actualResult);
    }

    //TODO write some other tests to see what happens when some values are null
}
