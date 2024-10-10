package com.mgms.service.impl;

import com.mgms.dao.TeacherDao;
import com.mgms.dto.TeacherDTO;
import com.mgms.model.Teacher;
import com.mgms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherDao.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        Teacher teacher = teacherDao.findById(id);
        return teacher != null ? convertToDTO(teacher) : null;
    }

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = convertToEntity(teacherDTO);
        return convertToDTO(teacherDao.save(teacher));
    }

    @Override
    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Teacher teacher = teacherDao.findById(id);
        if (teacher != null) {
            teacher.setName(teacherDTO.getName());
            teacher.setEmail(teacherDTO.getEmail());
            teacher.setSubject(teacherDTO.getSubject());
            return convertToDTO(teacherDao.save(teacher));
        }
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherDao.deleteById(id);
    }

    private TeacherDTO convertToDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        dto.setSubject(teacher.getSubject());
        return dto;
    }

    private Teacher convertToEntity(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setId(dto.getId());
        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        teacher.setSubject(dto.getSubject());
        return teacher;
    }
}