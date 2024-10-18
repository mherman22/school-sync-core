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

import com.mgms.dao.ClassDao;
import com.mgms.model.Class;

@Repository
public class ClassDaoImpl implements ClassDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<Class> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Class", Class.class).list();
  }

  @Override
  public Class findById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Class.class, id);
  }

  @Override
  public Class save(Class classObj) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(classObj);
    return classObj;
  }

  @Override
  public void deleteById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    Class classObj = session.get(Class.class, id);
    if (classObj != null) {
      session.delete(classObj);
    }
  }
}
