package com.placement.backendProject.service;

import com.placement.backendProject.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class sService implements iService{

    private List<Student> students = new ArrayList<>();

    @Override
    public void createStudent(Student student) {
        students.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }
    }

    @Override
    public void deleteStudent(Student student) {
        students.remove(student);
    }
}
