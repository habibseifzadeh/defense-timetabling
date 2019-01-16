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
    private String title;

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

    public void addSupervisor(Professor supervisor) {
        this.supervisor = supervisor;
        supervisor.getSupervisorSessions().add(this);
    }

    public void addAdvisor(Professor advisor) {
        this.advisor = advisor;
        advisor.getAdvisorSessions().add(this);
    }

    public void addInternalReviewer(Professor internalReviewer) {
        this.internalReviewer = internalReviewer;
        internalReviewer.getInternalReviewerSessions().add(this);
    }

    public void addExternalReviewer(Professor externalReviewer) {
        this.externalReviewer = externalReviewer;
        externalReviewer.getExternalReviewerSessions().add(this);
    }

    public void addCoordinator(Professor coordinator) {
        this.coordinator = coordinator;
        coordinator.getCoordinatorSessions().add(this);
    }

    public void addUnitOfTime(UnitOfTime unitOfTime) {
        this.unitOfTime = unitOfTime;
        unitOfTime.getDefenseSessions().add(this);
    }

    public void addStudent(Student student) {
        this.student = student;
        student.setDefenseSession(this);
    }
}
