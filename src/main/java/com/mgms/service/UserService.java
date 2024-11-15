/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service;

import java.util.List;

import com.mgms.dto.LoginDTO;
import com.mgms.dto.SignupDTO;
import com.mgms.model.User;

public interface UserService {
  List<User> getAllUsers();

  User getUserById(Long id);

  User getUserByUsername(String username);

  User createUser(User user);

  User updateUser(Long id, User user);

  void deleteUser(Long id);

  User signup(SignupDTO signupDTO);

  String login(LoginDTO loginDTO);
}
