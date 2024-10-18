/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao;

import java.util.List;

import com.mgms.model.Teacher;

public interface TeacherDao {
  List<Teacher> findAll();

  Teacher findById(Long id);

  Teacher save(Teacher teacher);

  void deleteById(Long id);
}
