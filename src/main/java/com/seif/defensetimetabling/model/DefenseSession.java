package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class DefenseSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    private Professor supervisor;
    @ManyToOne
    private Professor advisor;
    @ManyToOne
    private Professor internalReviewer;
    @ManyToOne
    private Professor externalReviewer;
    @ManyToOne
    private Professor coordinator;

    @ManyToOne
    private UnitOfTime unitOfTime;

    @OneToOne
    private Student student;
}
