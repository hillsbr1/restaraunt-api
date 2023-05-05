package jhu.rest.service;

import jhu.rest.jpa.Student;
import jhu.rest.jpa.StudentRepository;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        Optional<Student> result = studentRepository.findStudentById(id);
        return result.get();
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().iterator().forEachRemaining(students::add);
        return students;
    }
}
