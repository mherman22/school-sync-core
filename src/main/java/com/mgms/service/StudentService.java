/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.dto.StudentDTO;

public interface StudentService {
  List<StudentDTO> getAllStudents();

  StudentDTO getStudentById(Long id);

  StudentDTO createStudent(StudentDTO studentDTO);

  StudentDTO updateStudent(Long id, StudentDTO studentDTO);

  void deleteStudent(Long id);
}
