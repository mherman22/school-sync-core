package com.mgms.controller;

import com.mgms.model.Class;
import com.mgms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        Class classObj = classService.getClassById(id);
        return classObj != null ? ResponseEntity.ok(classObj) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Class createClass(@Valid @RequestBody Class classObj) {
        return classService.createClass(classObj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @Valid @RequestBody Class classDetails) {
        Class updatedClass = classService.updateClass(id, classDetails);
        return updatedClass != null ? ResponseEntity.ok(updatedClass) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }
}