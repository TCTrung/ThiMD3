package com.example.thimd3.model;

import java.util.List;

public interface IStudentDAO {
    List<Student> selectAllStudents();
    boolean updateStudent(Student student);
    boolean delete(int id);
    Student selectStudent(int id);
    void insert(Student student);

}
