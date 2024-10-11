package com.mgms.service.impl;

import com.mgms.dao.StudentDao;
import com.mgms.dto.StudentDTO;
import com.mgms.model.Student;
import com.mgms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDao.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentDao.findById(id);
        return student != null ? convertToDTO(student) : null;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentDao.save(student));
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentDao.findById(id);
        if (student != null) {
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setClassName(studentDTO.getClassName());
            return convertToDTO(studentDao.save(student));
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setClassName(student.getClassName());
        return dto;
    }

    private Student convertToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setClassName(dto.getClassName());
        return student;
    }
}
