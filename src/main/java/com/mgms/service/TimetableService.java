/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.model.Timetable;

public interface TimetableService {
  List<Timetable> getAllTimetables();

  Timetable getTimetableById(Long id);

  Timetable createTimetable(Timetable timetable);

  Timetable updateTimetable(Long id, Timetable timetable);

  void deleteTimetable(Long id);
}
