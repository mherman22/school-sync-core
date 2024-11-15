/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mgms.model.Timetable;
import com.mgms.service.TimetableService;

@RestController
@RequestMapping("/api/timetables")
public class TimetableController {

  @Autowired private TimetableService timetableService;

  @GetMapping
  public ResponseEntity<List<Timetable>> getAllTimetables() {
    return ResponseEntity.ok(timetableService.getAllTimetables());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Timetable> getTimetableById(@PathVariable Long id) {
    Timetable timetable = timetableService.getTimetableById(id);
    return timetable != null ? ResponseEntity.ok(timetable) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) {
    return ResponseEntity.ok(timetableService.createTimetable(timetable));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Timetable> updateTimetable(
      @PathVariable Long id, @RequestBody Timetable timetable) {
    Timetable updatedTimetable = timetableService.updateTimetable(id, timetable);
    return updatedTimetable != null
        ? ResponseEntity.ok(updatedTimetable)
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTimetable(@PathVariable Long id) {
    timetableService.deleteTimetable(id);
    return ResponseEntity.ok().build();
  }
}
