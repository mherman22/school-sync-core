/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.dto.TeacherDTO;

public interface TeacherService {
  List<TeacherDTO> getAllTeachers();

  TeacherDTO getTeacherById(Long id);

  TeacherDTO createTeacher(TeacherDTO teacherDTO);

  TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO);

  void deleteTeacher(Long id);
}
