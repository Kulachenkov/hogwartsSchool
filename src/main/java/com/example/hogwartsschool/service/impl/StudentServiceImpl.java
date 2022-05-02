package com.example.hogwartsschool.service.impl;

import com.example.hogwartsschool.model.Student;
import com.example.hogwartsschool.repository.StudentRepository;
import com.example.hogwartsschool.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student deletedStudent = studentRepository.getById(id);
        studentRepository.deleteById(id);
        return deletedStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentsByAge(int min, int max) {
        return studentRepository.findStudentsByAgeBetween(min, max);
    }

}
