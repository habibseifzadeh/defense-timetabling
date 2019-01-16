package com.seif.defensetimetabling.repositories;

import com.seif.defensetimetabling.model.Professor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class RepositoriesTest {

    @Mock
    private ProfessorRepository professorRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProfessorsFindByName() {

        //given
        Professor professor = new Professor();
        professor.setId(1l);
        professor.setFirstName("habib");
        professor.setLastName("seifzadeh");
        when(professorRepository.findByLastNameAndFirstName(anyString(), anyString()))
                .thenReturn(Optional.of(professor));

        //when
        Optional<Professor> actualResult =
                professorRepository.findByLastNameAndFirstName("habib", "seifzadeh");

        //then
        assertEquals(professor, actualResult.get());

    }

}
