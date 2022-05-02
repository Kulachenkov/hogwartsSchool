package com.example.hogwartsschool.service;

import com.example.hogwartsschool.model.Faculty;
import com.example.hogwartsschool.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student findStudent(Long id);

    Student updateStudent(Student student);

    Student deleteStudent(Long id);

    List<Student> getAllStudents();

    List<Student> findStudentsByAge(int min, int max);
}
