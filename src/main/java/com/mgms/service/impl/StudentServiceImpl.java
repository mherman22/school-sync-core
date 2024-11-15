/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgms.dao.StudentDao;
import com.mgms.model.Student;
import com.mgms.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

  @Autowired private StudentDao studentDao;

  @Override
  public List<Student> getAllStudents() {
    return studentDao.findAll();
  }

  @Override
  public Student getStudentById(Long id) {
    return studentDao.findById(id);
  }

  @Override
  public Student createStudent(Student student) {
    return studentDao.save(student);
  }

  @Override
  public Student updateStudent(Long id, Student student) {
    Student existingStudent = studentDao.findById(id);
    if (existingStudent != null) {
      existingStudent.setName(student.getName());
      existingStudent.setEmail(student.getEmail());
      return studentDao.save(existingStudent);
    }
    return null;
  }

  @Override
  public void deleteStudent(Long id) {
    studentDao.deleteById(id);
  }
}
