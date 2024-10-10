package com.mgms.service;

import com.mgms.dto.TimetableDTO;
import java.util.List;

public interface TimetableService {
    List<TimetableDTO> getAllTimetables();
    TimetableDTO getTimetableById(Long id);
    List<TimetableDTO> getTimetablesByClass(Long classId);
    List<TimetableDTO> getTimetablesByTeacher(Long teacherId);
    TimetableDTO createTimetable(TimetableDTO timetableDTO);
    TimetableDTO updateTimetable(Long id, TimetableDTO timetableDTO);
    void deleteTimetable(Long id);
}