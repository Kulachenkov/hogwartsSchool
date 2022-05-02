package com.example.hogwartsschool.service;

import com.example.hogwartsschool.model.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty findFaculty(Long id);

    Faculty updateFaculty(Faculty faculty);

    Faculty deleteFaculty(Long id);

    List<Faculty> getAllFaculties();

    List<Faculty> findFacultyByNameAndColor(String name, String color);

}
