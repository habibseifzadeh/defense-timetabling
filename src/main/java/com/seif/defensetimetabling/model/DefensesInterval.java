package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class DefensesInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Semester semester;
    @OneToMany(mappedBy = "defensesInterval")
    private Set<UnitOfTime> unitsOfTime = new HashSet<>();
}
