package com.mgms.service;

import com.mgms.model.Class;
import com.mgms.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class createClass(Class classObj) {
        return classRepository.save(classObj);
    }

    public Class updateClass(Long id, Class classDetails) {
        Class classObj = classRepository.findById(id).orElse(null);
        if (classObj != null) {
            classObj.setName(classDetails.getName());
            classObj.setCapacity(classDetails.getCapacity());
            return classRepository.save(classObj);
        }
        return null;
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }
}