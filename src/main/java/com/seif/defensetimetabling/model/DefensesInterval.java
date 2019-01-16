package com.seif.defensetimetabling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "unitOfTimes")
public class DefensesInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Semester semester;
    @OneToMany(mappedBy = "defensesInterval")
    private Set<UnitOfTime> unitOfTimes = new HashSet<>();

    public void addSemester(Semester semester) {
        this.semester = semester;
        semester.getDefensesIntervals().add(this);
    }

    public void addUnitOfTime(UnitOfTime unitOfTime) {
        unitOfTimes.add(unitOfTime);
        unitOfTime.setDefensesInterval(this);
    }
}
