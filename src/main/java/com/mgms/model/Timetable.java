/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
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
