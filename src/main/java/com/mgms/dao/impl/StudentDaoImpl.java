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

import com.mgms.dao.StudentDao;
import com.mgms.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<Student> findAll() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Student", Student.class).list();
  }

  @Override
  public Student findById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Student.class, id);
  }

  @Override
  public Student save(Student student) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(student);
    return student;
  }

  @Override
  public void deleteById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    Student student = session.get(Student.class, id);
    if (student != null) {
      session.delete(student);
    }
  }
}
