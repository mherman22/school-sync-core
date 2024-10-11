package com.mgms.dao;

import com.mgms.model.Teacher;
import java.util.List;

public interface TeacherDao {
    List<Teacher> findAll();
    Teacher findById(Long id);
    Teacher save(Teacher teacher);
    void deleteById(Long id);
}
