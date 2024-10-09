package com.mgms.service;

import com.mgms.model.Timetable;
import com.mgms.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    public Timetable getTimetableById(Long id) {
        return timetableRepository.findById(id).orElse(null);
    }

    public List<Timetable> getTimetablesByClass(Long classId) {
        return timetableRepository.findByClassObjId(classId);
    }

    public List<Timetable> getTimetablesByTeacher(Long teacherId) {
        return timetableRepository.findByTeacherId(teacherId);
    }

    public Timetable createTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    public Timetable updateTimetable(Long id, Timetable timetableDetails) {
        Timetable timetable = timetableRepository.findById(id).orElse(null);
        if (timetable != null) {
            timetable.setClassObj(timetableDetails.getClassObj());
            timetable.setTeacher(timetableDetails.getTeacher());
            timetable.setSubject(timetableDetails.getSubject());
            timetable.setDayOfWeek(timetableDetails.getDayOfWeek());
            timetable.setStartTime(timetableDetails.getStartTime());
            timetable.setEndTime(timetableDetails.getEndTime());
            return timetableRepository.save(timetable);
        }
        return null;
    }

    public void deleteTimetable(Long id) {
        timetableRepository.deleteById(id);
    }
}