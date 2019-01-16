package com.seif.defensetimetabling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "defenseSession")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentNumber;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(mappedBy = "student")
    private DefenseSession defenseSession;
}
