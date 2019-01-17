package com.seif.defensetimetabling.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIndexPage() throws Exception {
        //when
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();

        //then
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("/admin/index"));
    }
}
