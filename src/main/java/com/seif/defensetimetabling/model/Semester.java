package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "semester")
    private Set<DefensesInterval> defensesIntervals = new HashSet<>();
}
