package com.mgms.service.impl;

import com.mgms.dao.ClassDao;
import com.mgms.dto.ClassDTO;
import com.mgms.model.Class;
import com.mgms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<ClassDTO> getAllClasses() {
        return classDao.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClassDTO getClassById(Long id) {
        Class classObj = classDao.findById(id);
        return classObj != null ? convertToDTO(classObj) : null;
    }

    @Override
    public ClassDTO createClass(ClassDTO classDTO) {
        Class classObj = convertToEntity(classDTO);
        return convertToDTO(classDao.save(classObj));
    }

    @Override
    public ClassDTO updateClass(Long id, ClassDTO classDTO) {
        Class classObj = classDao.findById(id);
        if (classObj != null) {
            classObj.setName(classDTO.getName());
            classObj.setCapacity(classDTO.getCapacity());
            return convertToDTO(classDao.save(classObj));
        }
        return null;
    }

    @Override
    public void deleteClass(Long id) {
        classDao.deleteById(id);
    }

    private ClassDTO convertToDTO(Class classObj) {
        ClassDTO dto = new ClassDTO();
        dto.setId(classObj.getId());
        dto.setName(classObj.getName());
        dto.setCapacity(classObj.getCapacity());
        return dto;
    }

    private Class convertToEntity(ClassDTO dto) {
        Class classObj = new Class();
        classObj.setId(dto.getId());
        classObj.setName(dto.getName());
        classObj.setCapacity(dto.getCapacity());
        return classObj;
    }
}