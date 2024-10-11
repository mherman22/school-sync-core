package com.mgms.controller;

import com.mgms.dto.TimetableDTO;
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
    public ResponseEntity<List<TimetableDTO>> getAllTimetables() {
        return ResponseEntity.ok(timetableService.getAllTimetables());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableDTO> getTimetableById(@PathVariable Long id) {
        TimetableDTO timetableDTO = timetableService.getTimetableById(id);
        return timetableDTO != null ? ResponseEntity.ok(timetableDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<TimetableDTO>> getTimetablesByClass(@PathVariable Long classId) {
        return ResponseEntity.ok(timetableService.getTimetablesByClass(classId));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<TimetableDTO>> getTimetablesByTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(timetableService.getTimetablesByTeacher(teacherId));
    }

    @PostMapping
    public ResponseEntity<TimetableDTO> createTimetable(@Valid @RequestBody TimetableDTO timetableDTO) {
        return ResponseEntity.ok(timetableService.createTimetable(timetableDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimetableDTO> updateTimetable(@PathVariable Long id, @Valid @RequestBody TimetableDTO timetableDTO) {
        TimetableDTO updatedTimetable = timetableService.updateTimetable(id, timetableDTO);
        return updatedTimetable != null ? ResponseEntity.ok(updatedTimetable) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.ok().build();
    }
}
