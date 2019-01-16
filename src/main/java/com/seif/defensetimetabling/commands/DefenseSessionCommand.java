package com.seif.defensetimetabling.commands;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DefenseSessionCommand {
    private Long id;
    private String supervisorFirstName;
    private String supervisorLastName;
    private String advisorFirstName;
    private String advisorLastName;
    private String externalReviewerFirstName;
    private String externalReviewerLastName;
    private String internalReviewerFirstName;
    private String internalReviewerLastName;
    private String coordinatorFirstName;
    private String coordinatorLastName;
    private String studentFirstName;
    private String studentLastName;
    private String time;
    private LocalDate date;
    private String title;
}
