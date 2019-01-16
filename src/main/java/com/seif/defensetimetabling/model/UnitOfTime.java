package com.seif.defensetimetabling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "defenseSessions")
public class UnitOfTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    private DefensesInterval defensesInterval;
    @OneToMany(mappedBy = "unitOfTime")
    private Set<LeaveTime> leaveTimes = new HashSet<>();
    @OneToMany(mappedBy = "unitOfTime")
    private Set<DefenseSession> defenseSessions = new HashSet<>();
}
