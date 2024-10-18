package com.mgms.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Timetable {
  private Long id;
  private Class classObj;
  private Teacher teacher;
  private String subject;
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;
}
