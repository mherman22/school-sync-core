/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao;

import java.util.List;

import com.mgms.model.Class;

public interface ClassDao {
  List<Class> findAll();

  Class findById(Long id);

  Class save(Class classObj);

  void deleteById(Long id);
}
