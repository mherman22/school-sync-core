package com.mgms.dao;

import com.mgms.model.Timetable;
import java.util.List;

public interface TimetableDao {
    List<Timetable> findAll();
    Timetable findById(Long id);
    List<Timetable> findByClassId(Long classId);
    List<Timetable> findByTeacherId(Long teacherId);
    Timetable save(Timetable timetable);
    void deleteById(Long id);
}
