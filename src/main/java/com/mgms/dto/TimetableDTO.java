package com.mgms.dto;

import com.mgms.model.Class;
import com.mgms.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class TimetableDTO {
    private Long id;

    @NotNull(message = "Class is required")
    private Class classObj;

    @NotNull(message = "Teacher is required")
    private Teacher teacher;

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotNull(message = "Day of week is required")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;
}
