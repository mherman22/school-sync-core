/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgms.dao.UserDao;
import com.mgms.dto.LoginDTO;
import com.mgms.dto.SignupDTO;
import com.mgms.dto.UserDTO;
import com.mgms.model.User;
import com.mgms.security.JwtUtil;
import com.mgms.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired private UserDao userDao;

  @Autowired private JwtUtil jwtUtil;

  @Override
  public List<UserDTO> getAllUsers() {
    return userDao.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  @Override
  public UserDTO getUserById(Long id) {
    User user = userDao.findById(id);
    return user != null ? convertToDTO(user) : null;
  }

  @Override
  public UserDTO getUserByUsername(String username) {
    User user = userDao.findByUsername(username);
    return user != null ? convertToDTO(user) : null;
  }

  @Override
  public UserDTO createUser(UserDTO userDTO) {
    User user = convertToEntity(userDTO);
    return convertToDTO(userDao.save(user));
  }

  @Override
  public UserDTO updateUser(Long id, UserDTO userDTO) {
    User user = userDao.findById(id);
    if (user != null) {
      user.setUsername(userDTO.getUsername());
      user.setEmail(userDTO.getEmail());
      user.setRole(userDTO.getRole());
      // Don't update password here, create a separate method for password change
      return convertToDTO(userDao.save(user));
    }
    return null;
  }

  @Override
  public void deleteUser(Long id) {
    userDao.deleteById(id);
  }

  @Override
  public UserDTO signup(SignupDTO signupDTO) {
    User existingUser = userDao.findByUsername(signupDTO.getUsername());
    if (existingUser != null) {
      throw new RuntimeException("Username already exists");
    }

    User user = new User();
    user.setUsername(signupDTO.getUsername());
    user.setEmail(signupDTO.getEmail());
    user.setPassword(BCrypt.hashpw(signupDTO.getPassword(), BCrypt.gensalt()));
    user.setRole(signupDTO.getRole());

    User savedUser = userDao.save(user);
    return convertToDTO(savedUser);
  }

  @Override
  public String login(LoginDTO loginDTO) {
    User user = userDao.findByUsername(loginDTO.getUsername());
    if (user == null || !BCrypt.checkpw(loginDTO.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid username or password");
    }

    return jwtUtil.generateToken(user.getUsername(), user.getRole());
  }

  private UserDTO convertToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setRole(user.getRole());
    return dto;
  }

  private User convertToEntity(UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setUsername(dto.getUsername());
    user.setEmail(dto.getEmail());
    user.setRole(dto.getRole());
    return user;
  }
}
