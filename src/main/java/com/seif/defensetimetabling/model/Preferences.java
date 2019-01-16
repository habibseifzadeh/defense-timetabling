package com.seif.defensetimetabling.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
