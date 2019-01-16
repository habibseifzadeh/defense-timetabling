package com.seif.defensetimetabling.controllers;

import com.seif.defensetimetabling.services.DefenseSessionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ControllersTest {

    @Mock
    private DefenseSessionService defenseSessionService;

    @InjectMocks
    private IndexController indexController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIndexPageOfIndexController() throws Exception {
        //when
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        //then
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

        verify(defenseSessionService, times(1)).findAll();
    }
}
