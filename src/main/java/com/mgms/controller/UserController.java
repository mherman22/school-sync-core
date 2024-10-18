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
import com.mgms.dto.UserDTO;
import com.mgms.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
    UserDTO userDTO = userService.getUserById(id);
    return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
    UserDTO userDTO = userService.getUserByUsername(username);
    return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
    return ResponseEntity.ok(userService.createUser(userDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(
      @PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
    UserDTO updatedUser = userService.updateUser(id, userDTO);
    return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/signup")
  public ResponseEntity<UserDTO> signup(@Valid @RequestBody SignupDTO signupDTO) {
    return ResponseEntity.ok(userService.signup(signupDTO));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
    String token = userService.login(loginDTO);
    return ResponseEntity.ok(token);
  }
}
