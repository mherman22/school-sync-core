package com.mgms.service;

import com.mgms.dto.LoginDTO;
import com.mgms.dto.SignupDTO;
import com.mgms.dto.UserDTO;
import java.util.List;

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
