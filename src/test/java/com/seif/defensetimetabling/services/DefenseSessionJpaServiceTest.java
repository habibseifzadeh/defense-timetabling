package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.DefenseSessionCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DefenseSessionJpaServiceTest {

    @Mock
    private DefenseSessionJpaService defenseSessionJpaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        //given
        DefenseSessionCommand command = new DefenseSessionCommand();
        command.setAdvisorFirstName("habib");
        command.setAdvisorLastName("seifzadeh");
        command.setSupervisorFirstName("habib");
        command.setSupervisorLastName("seifzadeh");
        command.setExternalReviewerFirstName("habib");
        command.setExternalReviewerLastName("seifzadeh");
        command.setInternalReviewerFirstName("habib");
        command.setInternalReviewerLastName("seifzadeh");
        command.setCoordinatorFirstName("habib");
        command.setCoordinatorLastName("seifzadeh");
        command.setStudentFirstName("razieh");
        command.setStudentLastName("yaghoubi");
        command.setTime("8-9:30");
        command.setDate(LocalDate.now());
        command.setTitle("this is a title");

        Set<DefenseSessionCommand> commandSet = new HashSet<>();
        commandSet.add(command);

        when(defenseSessionJpaService.findAll()).thenReturn(commandSet);

        //when
        Set<DefenseSessionCommand> actualResult = defenseSessionJpaService.findAll();

        //then
        assertEquals(command, actualResult.iterator().next());
    }
}
