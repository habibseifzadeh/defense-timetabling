package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class LeaveTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    private UnitOfTime unitOfTime;
    @ManyToOne
    private Professor professor;
}
