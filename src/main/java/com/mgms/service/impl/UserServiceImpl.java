/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgms.dao.UserDao;
import com.mgms.dto.LoginDTO;
import com.mgms.dto.SignupDTO;
import com.mgms.model.User;
import com.mgms.security.JwtUtil;
import com.mgms.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired private UserDao userDao;

  @Autowired private JwtUtil jwtUtil;

  @Override
  public List<User> getAllUsers() {
    return userDao.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userDao.findById(id);
  }

  @Override
  public User getUserByUsername(String username) {
    User user = userDao.findByUsername(username);
    return user != null ? user : null;
  }

  @Override
  public User createUser(User user) {
    return userDao.save(user);
  }

  @Override
  public User updateUser(Long id, User user) {
    User existingUser = userDao.findById(id);
    if (existingUser != null) {
      existingUser.setUsername(user.getUsername());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());
      existingUser.setRole(user.getRole());
      return userDao.save(existingUser);
    }
    return null;
  }

  @Override
  public void deleteUser(Long id) {
    userDao.deleteById(id);
  }

  @Override
  public User signup(SignupDTO signupDTO) {
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
    return savedUser;
  }

  @Override
  public String login(LoginDTO loginDTO) {
    User user = userDao.findByUsername(loginDTO.getUsername());
    if (user == null || !BCrypt.checkpw(loginDTO.getPassword(), user.getPassword())) {
      throw new RuntimeException("Invalid username or password");
    }

    return jwtUtil.generateToken(user.getUsername(), user.getRole());
  }
}
