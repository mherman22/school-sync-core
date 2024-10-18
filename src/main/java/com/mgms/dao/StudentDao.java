/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao;

import java.util.List;

import com.mgms.model.Student;

public interface StudentDao {
  List<Student> findAll();

  Student findById(Long id);

  Student save(Student student);

  void deleteById(Long id);
}
