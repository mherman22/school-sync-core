package com.mgms.repository;

import com.mgms.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByClassObjId(Long classId);
    List<Timetable> findByTeacherId(Long teacherId);
}