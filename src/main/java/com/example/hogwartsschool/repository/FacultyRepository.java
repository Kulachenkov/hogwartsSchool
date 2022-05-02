package com.example.hogwartsschool.repository;

import com.example.hogwartsschool.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findFacultiesByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
