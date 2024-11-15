/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mgms.dto.LoginDTO;
import com.mgms.dto.SignupDTO;
import com.mgms.model.User;
import com.mgms.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
    User user = userService.getUserByUsername(username);
    return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    return ResponseEntity.ok(userService.createUser(user));
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
    User updatedUser = userService.updateUser(id, user);
    return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/signup")
  public ResponseEntity<User> signup(@Valid @RequestBody SignupDTO signupDTO) {
    return ResponseEntity.ok(userService.signup(signupDTO));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
    String token = userService.login(loginDTO);
    return ResponseEntity.ok(token);
  }
}
