package com.placement.backendProject.service;

import com.placement.backendProject.Model.Student;

import java.util.List;

public interface iService {
    void createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long id);

    void updateStudent(Student student);

    void deleteStudent(Student student);
}

