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

import com.mgms.dao.TimetableDao;
import com.mgms.exception.ResourceActionNotYetImplemented;
import com.mgms.model.Timetable;
import com.mgms.service.TimetableService;

@Service
@Transactional
public class TimetableServiceImpl implements TimetableService {

  @Autowired private TimetableDao timetableDao;

  @Override
  public List<Timetable> getAllTimetables() {
    return timetableDao.findAll();
  }

  @Override
  public Timetable getTimetableById(Long id) {
    return timetableDao.findById(id);
  }

  @Override
  public Timetable createTimetable(Timetable timetable) {
    return timetableDao.save(timetable);
  }

  @Override
  public Timetable updateTimetable(Long id, Timetable timetable) {
    throw new ResourceActionNotYetImplemented("Updating Timetable not Yet Implemented");
  }

  @Override
  public void deleteTimetable(Long id) {
    timetableDao.deleteById(id);
  }
}
