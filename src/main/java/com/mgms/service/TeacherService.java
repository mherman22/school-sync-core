/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.model.Teacher;

public interface TeacherService {
  List<Teacher> getAllTeachers();

  Teacher getTeacherById(Long id);

  Teacher createTeacher(Teacher teacher);

  Teacher updateTeacher(Long id, Teacher teacher);

  void deleteTeacher(Long id);
}
