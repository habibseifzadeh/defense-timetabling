package com.seif.defensetimetabling.converters;

import com.seif.defensetimetabling.commands.DefenseSessionCommand;
import com.seif.defensetimetabling.model.DefenseSession;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DefenseSessionToDefenseSessionCommand implements Converter<DefenseSession, DefenseSessionCommand> {
    @Override
    public DefenseSessionCommand convert(DefenseSession defenseSession) {

        //TODO check for NPE: for example, when the time or reviewer is null

        DefenseSessionCommand result = new DefenseSessionCommand();
        result.setId(defenseSession.getId());
        result.setSupervisorFirstName(defenseSession.getSupervisor().getFirstName());
        result.setSupervisorLastName(defenseSession.getSupervisor().getLastName());
        result.setAdvisorFirstName(defenseSession.getAdvisor().getFirstName());
        result.setAdvisorLastName(defenseSession.getAdvisor().getLastName());
        result.setExternalReviewerFirstName(defenseSession.getExternalReviewer().getFirstName());
        result.setExternalReviewerLastName(defenseSession.getExternalReviewer().getLastName());
        result.setInternalReviewerFirstName(defenseSession.getInternalReviewer().getFirstName());
        result.setInternalReviewerLastName(defenseSession.getInternalReviewer().getLastName());
        result.setCoordinatorFirstName(defenseSession.getCoordinator().getFirstName());
        result.setCoordinatorLastName(defenseSession.getCoordinator().getLastName());
        result.setStudentFirstName(defenseSession.getStudent().getFirstName());
        result.setStudentLastName(defenseSession.getStudent().getLastName());
        result.setTime(defenseSession.getUnitOfTime().getDescription());
        result.setDate(defenseSession.getDate());
        result.setTitle(defenseSession.getTitle());

        return result;
    }
}
