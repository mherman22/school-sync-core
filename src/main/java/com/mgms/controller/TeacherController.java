package com.mgms.controller;

import com.mgms.dto.TeacherDTO;
import com.mgms.service.TeacherService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

  @Autowired private TeacherService teacherService;

  @GetMapping
  public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
    return ResponseEntity.ok(teacherService.getAllTeachers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
    TeacherDTO teacherDTO = teacherService.getTeacherById(id);
    return teacherDTO != null ? ResponseEntity.ok(teacherDTO) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<TeacherDTO> createTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
    return ResponseEntity.ok(teacherService.createTeacher(teacherDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TeacherDTO> updateTeacher(
      @PathVariable Long id, @Valid @RequestBody TeacherDTO teacherDTO) {
    TeacherDTO updatedTeacher = teacherService.updateTeacher(id, teacherDTO);
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
