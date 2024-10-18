/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao;

import java.util.List;

import com.mgms.model.Timetable;

public interface TimetableDao {
  List<Timetable> findAll();

  Timetable findById(Long id);

  List<Timetable> findByClassId(Long classId);

  List<Timetable> findByTeacherId(Long teacherId);

  Timetable save(Timetable timetable);

  void deleteById(Long id);
}
