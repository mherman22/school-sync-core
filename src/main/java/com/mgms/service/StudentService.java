/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.model.Student;

public interface StudentService {
  List<Student> getAllStudents();

  Student getStudentById(Long id);

  Student createStudent(Student student);

  Student updateStudent(Long id, Student student);

  void deleteStudent(Long id);
}
