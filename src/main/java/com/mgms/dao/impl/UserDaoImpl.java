/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mgms.dao.UserDao;
import com.mgms.model.User;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<User> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from User", User.class).list();
  }

  @Override
  public User findById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(User.class, id);
  }

  @Override
  public User findByUsername(String username) {
    Session session = sessionFactory.getCurrentSession();
    return session
        .createQuery("from User u where u.username = :username", User.class)
        .setParameter("username", username)
        .uniqueResult();
  }

  @Override
  public User save(User user) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(user);
    return user;
  }

  @Override
  public void deleteById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    User user = session.get(User.class, id);
    if (user != null) {
      session.delete(user);
    }
  }
}
