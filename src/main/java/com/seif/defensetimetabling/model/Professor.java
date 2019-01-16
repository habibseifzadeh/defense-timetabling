package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    private Preferences preferences;
    @OneToMany(mappedBy = "professor")
    private Set<LeaveTime> leaveTimes = new HashSet<>();

    @OneToMany(mappedBy = "supervisor")
    private Set<DefenseSession> supervisorSessions = new HashSet<>();
    @OneToMany(mappedBy = "advisor")
    private Set<DefenseSession> advisorSessions = new HashSet<>();
    @OneToMany(mappedBy = "coordinator")
    private Set<DefenseSession> coordinatorSessions = new HashSet<>();
    @OneToMany(mappedBy = "externalReviewer")
    private Set<DefenseSession> externalReviewerSessions = new HashSet<>();
    @OneToMany(mappedBy = "internalReviewer")
    private Set<DefenseSession> internalReviewerSessions = new HashSet<>();
}
