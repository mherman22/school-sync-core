/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.dto.TimetableDTO;

public interface TimetableService {
  List<TimetableDTO> getAllTimetables();

  TimetableDTO getTimetableById(Long id);

  List<TimetableDTO> getTimetablesByClass(Long classId);

  List<TimetableDTO> getTimetablesByTeacher(Long teacherId);

  TimetableDTO createTimetable(TimetableDTO timetableDTO);

  TimetableDTO updateTimetable(Long id, TimetableDTO timetableDTO);

  void deleteTimetable(Long id);
}
