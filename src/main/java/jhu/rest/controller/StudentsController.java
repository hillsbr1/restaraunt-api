package jhu.rest.controller;

import jhu.rest.jpa.Students;
import jhu.rest.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping(value = "/api/students/student/{id}",produces = "application/json")
    public Students getUserDetail(@PathVariable Long id){
        return studentsService.findById(id);
    }

    @PutMapping(value = "/api/students/student/{id}",produces = "application/json")
    public Students getUserDetails(@PathVariable Long id){
        return studentsService.findById(id);
    }

//    @PutMapping(value = "/api/students/student/{id}",produces = "application/json")
//    public ResponseEntity updateStudentlist(@RequestParam(value ="StudentId") String StudentId,
//                                            @RequestParam(value ="Email") String Email,
//                                            @RequestParam(value ="DateOfBirth") String DateOfBirth,
//                                            @RequestParam(value ="LastName") String LastName,
//                                            @RequestParam(value ="FirstName") String FirstName,
//                                            @RequestParam(value ="id") Long id) {
//        myStudent.forEach(Studentlist -> {
//            if (Studentlist.getId() == id) {
//                Studentlist.setFirstName(FirstName);
//                Studentlist.setLastName(LastName);
//                Studentlist.setDateOfBirth(DateOfBirth);
//                Studentlist.setEmail(Email);
//                Studentlist.setStudentId(StudentId);
//            }
//        });
//        return ResponseEntity.ok(myStudent);
//    }
//
//    @DeleteMapping(value = "/api/students/student/{id}",produces = "application/json")
//    public ResponseEntity removePlaylist(@RequestParam(value ="id") Long id) {
//        Student itemToRemove = null;
//        for (Student play_list : myStudent) {
//            if (play_list.getId() == id)
//                itemToRemove = play_list;
//        }
//        myStudent.remove(itemToRemove);
//        return ResponseEntity.ok(myStudent);
//    }
}