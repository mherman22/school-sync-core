package com.mgms.service;

import com.mgms.dto.ClassDTO;
import java.util.List;

public interface ClassService {
    List<ClassDTO> getAllClasses();
    ClassDTO getClassById(Long id);
    ClassDTO createClass(ClassDTO classDTO);
    ClassDTO updateClass(Long id, ClassDTO classDTO);
    void deleteClass(Long id);
}
