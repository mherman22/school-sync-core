/*
 * Copyright (c) 2024 School Sync
 *
 * This file is part of School Sync Core, licensed under the MIT License.
 * For full license text, see the LICENSE file in the project root.
 */
package com.mgms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mgms.dto.ClassDTO;
import com.mgms.service.ClassService;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

  @Autowired private ClassService classService;

  @GetMapping
  public ResponseEntity<List<ClassDTO>> getAllClasses() {
    return ResponseEntity.ok(classService.getAllClasses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClassDTO> getClassById(@PathVariable Long id) {
    ClassDTO classDTO = classService.getClassById(id);
    return classDTO != null ? ResponseEntity.ok(classDTO) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<ClassDTO> createClass(@Valid @RequestBody ClassDTO classDTO) {
    return ResponseEntity.ok(classService.createClass(classDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClassDTO> updateClass(
      @PathVariable Long id, @Valid @RequestBody ClassDTO classDTO) {
    ClassDTO updatedClass = classService.updateClass(id, classDTO);
    return updatedClass != null
        ? ResponseEntity.ok(updatedClass)
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
    classService.deleteClass(id);
    return ResponseEntity.ok().build();
  }
}
