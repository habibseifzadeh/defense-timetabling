package com.seif.defensetimetabling.converters;

import com.seif.defensetimetabling.commands.SemesterCommand;
import com.seif.defensetimetabling.model.Semester;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SemesterToSemesterCommandTest {

    private final Long ID = 1l;
    private final String NAME = "971";
    private SemesterToSemesterCommand semesterToSemesterCommand;

    @Before
    public void setUp() throws Exception {
        semesterToSemesterCommand = new SemesterToSemesterCommand();
    }

    @Test
    public void testConvert() {
        //given
        Semester semester = new Semester();
        semester.setId(ID);
        semester.setName(NAME);

        SemesterCommand expectedResult = new SemesterCommand();
        expectedResult.setId(ID);
        expectedResult.setName(NAME);

        //when
        SemesterCommand actualResult = semesterToSemesterCommand.convert(semester);

        //then
        assertEquals(expectedResult, actualResult);
    }
}