/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.model.Class;

public interface ClassService {
  List<Class> getAllClasses();

  Class getClassById(Long id);

  Class createClass(Class classObj);

  Class updateClass(Long id, Class classObj);

  void deleteClass(Long id);
}
