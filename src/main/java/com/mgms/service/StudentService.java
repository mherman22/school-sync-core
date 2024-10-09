package com.mgms.service;

import com.mgms.dto.StudentDTO;
import com.mgms.model.Student;
import com.mgms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> convertToDTO(student))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> convertToDTO(student))
                .orElse(null);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentRepository.save(student));
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDTO.getName());
                    student.setEmail(studentDTO.getEmail());
                    student.setClassName(studentDTO.getClassName());
                    return convertToDTO(studentRepository.save(student));
                })
                .orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
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
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setClassName(dto.getClassName());
        return student;
    }
}