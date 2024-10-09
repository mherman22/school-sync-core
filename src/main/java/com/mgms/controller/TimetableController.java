package com.mgms.controller;

import com.mgms.model.Timetable;
import com.mgms.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {
    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public List<Timetable> getAllTimetables() {
        return timetableService.getAllTimetables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable Long id) {
        Timetable timetable = timetableService.getTimetableById(id);
        return timetable != null ? ResponseEntity.ok(timetable) : ResponseEntity.notFound().build();
    }

    @GetMapping("/class/{classId}")
    public List<Timetable> getTimetablesByClass(@PathVariable Long classId) {
        return timetableService.getTimetablesByClass(classId);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Timetable> getTimetablesByTeacher(@PathVariable Long teacherId) {
        return timetableService.getTimetablesByTeacher(teacherId);
    }

    @PostMapping
    public Timetable createTimetable(@Valid @RequestBody Timetable timetable) {
        return timetableService.createTimetable(timetable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable Long id, @Valid @RequestBody Timetable timetableDetails) {
        Timetable updatedTimetable = timetableService.updateTimetable(id, timetableDetails);
        return updatedTimetable != null ? ResponseEntity.ok(updatedTimetable) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.ok().build();
    }
}