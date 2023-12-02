package com.supraja.CRUD.DEMO.dao;

import com.supraja.CRUD.DEMO.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer studentId);

    List<Student> findAllStudents();

    List<Student> findStudentByLastName(String last_name);
}
