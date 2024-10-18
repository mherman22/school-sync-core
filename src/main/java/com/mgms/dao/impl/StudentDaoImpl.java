package com.mgms.dao.impl;

import com.mgms.dao.StudentDao;
import com.mgms.model.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
