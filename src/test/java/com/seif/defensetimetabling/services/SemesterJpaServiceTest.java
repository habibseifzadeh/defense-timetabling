package com.seif.defensetimetabling.services;

import com.seif.defensetimetabling.commands.SemesterCommand;
import com.seif.defensetimetabling.converters.SemesterToSemesterCommand;
import com.seif.defensetimetabling.model.Semester;
import com.seif.defensetimetabling.repositories.SemesterRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SemesterJpaServiceTest {

    @Mock
    private SemesterToSemesterCommand semesterToSemesterCommand;

    @Mock
    private SemesterRepository semesterRepository;

    @InjectMocks
    private SemesterJpaService semesterJpaService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {

        //given
        Semester semester = new Semester();
        semester.setId(1l);
        semester.setName("971");
        Set<Semester> semesterSet = new HashSet<>();
        semesterSet.add(semester);
        when(semesterRepository.findAll()).thenReturn(semesterSet);

        //when
        Set<SemesterCommand> commands = semesterJpaService.findAll();

        //then
        assertEquals(1, commands.size());
    }
}
