package jhu.rest.service;

import java.util.List;

import jhu.rest.jpa.Student;

public interface StudentService {
    Student findById(Long id);
    List<Student> getStudents();
}
