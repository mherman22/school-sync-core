package com.mgms.controller;

import com.mgms.dto.StudentDTO;
import com.mgms.service.StudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  @Autowired private StudentService studentService;

  @GetMapping
  public ResponseEntity<List<StudentDTO>> getAllStudents() {
    return ResponseEntity.ok(studentService.getAllStudents());
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
    StudentDTO student = studentService.getStudentById(id);
    return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
    return ResponseEntity.ok(studentService.createStudent(studentDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<StudentDTO> updateStudent(
      @PathVariable Long id, @Valid @RequestBody StudentDTO studentDTO) {
    StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
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
