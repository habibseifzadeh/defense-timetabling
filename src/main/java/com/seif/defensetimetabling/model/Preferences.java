package com.seif.defensetimetabling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "professor")
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int desiredNumberOfReview;
    private int desiredNumberOfCoordination;

    @OneToOne(mappedBy = "preferences")
    private Professor professor;
    @ManyToOne
    private DefensesInterval defensesInterval;
}
