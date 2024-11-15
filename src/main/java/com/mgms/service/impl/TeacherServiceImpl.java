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

import com.mgms.dao.TeacherDao;
import com.mgms.model.Teacher;
import com.mgms.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

  @Autowired private TeacherDao teacherDao;

  @Override
  public List<Teacher> getAllTeachers() {
    return teacherDao.findAll();
  }

  @Override
  public Teacher getTeacherById(Long id) {
    return teacherDao.findById(id);
  }

  @Override
  public Teacher createTeacher(Teacher teacher) {
    return teacherDao.save(teacher);
  }

  @Override
  public Teacher updateTeacher(Long id, Teacher teacher) {
    Teacher existingTeacher = teacherDao.findById(id);
    if (existingTeacher != null) {
      existingTeacher.setName(teacher.getName());
      existingTeacher.setEmail(teacher.getEmail());
      return teacherDao.save(existingTeacher);
    }
    return null;
  }

  @Override
  public void deleteTeacher(Long id) {
    teacherDao.deleteById(id);
  }
}
