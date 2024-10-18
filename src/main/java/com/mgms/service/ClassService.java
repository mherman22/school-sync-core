/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.dto.ClassDTO;

public interface ClassService {
  List<ClassDTO> getAllClasses();

  ClassDTO getClassById(Long id);

  ClassDTO createClass(ClassDTO classDTO);

  ClassDTO updateClass(Long id, ClassDTO classDTO);

  void deleteClass(Long id);
}
