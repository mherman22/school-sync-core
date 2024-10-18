/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao;

import java.util.List;

import com.mgms.model.User;

public interface UserDao {
  List<User> findAll();

  User findById(Long id);

  User findByUsername(String username);

  User save(User user);

  void deleteById(Long id);
}
