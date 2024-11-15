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

import com.mgms.model.Teacher;
import com.mgms.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

  @Autowired private TeacherService teacherService;

  @GetMapping
  public ResponseEntity<List<Teacher>> getAllTeachers() {
    return ResponseEntity.ok(teacherService.getAllTeachers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
    Teacher teacher = teacherService.getTeacherById(id);
    return teacher != null ? ResponseEntity.ok(teacher) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
    return ResponseEntity.ok(teacherService.createTeacher(teacher));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Teacher> updateTeacher(
      @PathVariable Long id, @RequestBody Teacher teacher) {
    Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
    return updatedTeacher != null
        ? ResponseEntity.ok(updatedTeacher)
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
    teacherService.deleteTeacher(id);
    return ResponseEntity.ok().build();
  }
}
