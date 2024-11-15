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

import com.mgms.model.Student;
import com.mgms.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  @Autowired private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok(studentService.getAllStudents());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    Student student = studentService.getStudentById(id);
    return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    return ResponseEntity.ok(studentService.createStudent(student));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(
      @PathVariable Long id, @RequestBody Student student) {
    Student updatedStudent = studentService.updateStudent(id, student);
    return updatedStudent != null
        ? ResponseEntity.ok(updatedStudent)
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return ResponseEntity.ok().build();
  }
}
