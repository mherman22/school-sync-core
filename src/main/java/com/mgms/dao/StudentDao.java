package com.mgms.dao;

import com.mgms.model.Student;
import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
    void deleteById(Long id);
}