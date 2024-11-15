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

import com.mgms.dao.ClassDao;
import com.mgms.model.Class;
import com.mgms.service.ClassService;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

  @Autowired private ClassDao classDao;

  @Override
  public List<Class> getAllClasses() {
    return classDao.findAll();
  }

  @Override
  public Class getClassById(Long id) {
    return classDao.findById(id);
  }

  @Override
  public Class createClass(Class classObj) {
    return classDao.save(classObj);
  }

  @Override
  public Class updateClass(Long id, Class classObj) {
    Class existingClass = classDao.findById(id);
    if (existingClass != null) {
      existingClass.setName(classObj.getName());
      return classDao.save(existingClass);
    }
    return null;
  }

  @Override
  public void deleteClass(Long id) {
    classDao.deleteById(id);
  }
}
