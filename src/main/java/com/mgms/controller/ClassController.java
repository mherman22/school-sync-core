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

import com.mgms.model.Class;
import com.mgms.service.ClassService;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

  @Autowired private ClassService classService;

  @GetMapping
  public ResponseEntity<List<Class>> getAllClasses() {
    return ResponseEntity.ok(classService.getAllClasses());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Class> getClassById(@PathVariable Long id) {
    Class classObj = classService.getClassById(id);
    return classObj != null ? ResponseEntity.ok(classObj) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Class> createClass(@RequestBody Class classObj) {
    return ResponseEntity.ok(classService.createClass(classObj));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class classObj) {
    Class updatedClass = classService.updateClass(id, classObj);
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
