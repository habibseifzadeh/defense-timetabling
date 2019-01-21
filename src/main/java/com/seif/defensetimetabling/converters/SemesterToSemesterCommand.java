package com.seif.defensetimetabling.converters;

import com.seif.defensetimetabling.commands.SemesterCommand;
import com.seif.defensetimetabling.model.Semester;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SemesterToSemesterCommand implements Converter<Semester, SemesterCommand> {
    @Override
    @Nullable
    public SemesterCommand convert(Semester semester) {

        if(semester == null) {
            return null;
        }

        SemesterCommand result = new SemesterCommand();
        result.setId(semester.getId());
        result.setName(semester.getName());

        return result;
    }
}
