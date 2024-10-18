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

import com.mgms.dao.TeacherDao;
import com.mgms.model.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<Teacher> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Teacher", Teacher.class).list();
  }

  @Override
  public Teacher findById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Teacher.class, id);
  }

  @Override
  public Teacher save(Teacher teacher) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(teacher);
    return teacher;
  }

  @Override
  public void deleteById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    Teacher teacher = session.get(Teacher.class, id);
    if (teacher != null) {
      session.delete(teacher);
    }
  }
}
