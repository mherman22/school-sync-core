package com.mgms.dao;

import com.mgms.model.User;
import java.util.List;

public interface UserDao {
  List<User> findAll();

  User findById(Long id);

  User findByUsername(String username);

  User save(User user);

  void deleteById(Long id);
}
