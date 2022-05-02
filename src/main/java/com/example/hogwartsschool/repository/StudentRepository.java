package com.example.hogwartsschool.repository;

import com.example.hogwartsschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAgeBetween(int min, int max);

}

