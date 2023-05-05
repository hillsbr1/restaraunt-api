package jhu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jhu.rest.jpa.Student;
import jhu.rest.service.ApiUserService;
import jhu.rest.service.StudentService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StudentController {
	private List<Student> students = new ArrayList<>();

	private final AtomicLong counter = new AtomicLong();

	public StudentController() {
		students.add(new Student(counter.incrementAndGet(), "Brian", "Hillsley", "6816"));
		students.add(new Student(counter.incrementAndGet(), "Eily", "Hillsley", "6816"));
		students.add(new Student(counter.incrementAndGet(), "Ryan", "Banta", "4567"));
	}

    @Autowired
    private StudentService studentService;

	@GetMapping(value = "/students/")
	public ResponseEntity<List<Student>> index() {

		System.out.println("+++++++++++++++++++ StudentController GET ++++++++++++++++");

        try {
            List<Student> students = studentService.getStudents();
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 not found
        }
	}
	
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long id) {

        try {
            Student s = studentService.findById(id);
            return ResponseEntity.ok(s);
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 not found
        }
    }

    @PostMapping(value = "/students/")
    public ResponseEntity<Student> addToStudents(
    		@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="address") String address) {
    	Student newStudent = new Student(counter.incrementAndGet(), firstName, lastName, address);
        students.add(newStudent);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(newStudent.getId()).toUri();

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.location(location)
        		.body(newStudent);
    }
    
    
    @PutMapping(value = "/students/{id}")
    public ResponseEntity<List<Student>> updateStudent(@PathVariable(value="id") Long id, @RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="address") String address) {
        students.forEach(student ->  {
            if(student.getId() == id){
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAddress(address);
            }
        });
        return ResponseEntity.ok(students);
    }
    
    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<List<Student>> removeStudent(@PathVariable(value="id") Long id) {
        Student itemToRemove = null;
        for(Student student : students){
            if(student.getId() == id)
                itemToRemove = student;
        }
        students.remove(itemToRemove);
        return ResponseEntity.ok(students);
    }
}