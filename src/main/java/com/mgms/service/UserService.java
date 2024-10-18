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
import com.mgms.dto.UserDTO;

public interface UserService {
  List<UserDTO> getAllUsers();

  UserDTO getUserById(Long id);

  UserDTO getUserByUsername(String username);

  UserDTO createUser(UserDTO userDTO);

  UserDTO updateUser(Long id, UserDTO userDTO);

  void deleteUser(Long id);

  UserDTO signup(SignupDTO signupDTO);

  String login(LoginDTO loginDTO);
}
