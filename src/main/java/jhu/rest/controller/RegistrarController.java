package jhu.rest.controller;

import jhu.rest.jpa.Registrar;
import jhu.rest.service.RegistrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrarController {

    @Autowired
    private RegistrarService registrarService;

    @GetMapping(value = "/api/registrars/registrar/{id}",produces = "application/json")
    public Registrar getUserDetail(@PathVariable Long id){
        return registrarService.findById(id);
    }
    
//
//    @DeleteMapping(value = "/api/registrars/registrar/{id}",produces = "application/json")
//    public ResponseEntity DropStudentFromGivenCourse(@RequestParam(value ="CourseNumber") Integer CourseNumber,
//                                                    @RequestParam(value ="StudentId") Integer StudentId) {
//        List<Integer> StudentList = CourseStudentMap.get(CourseNumber);
//        if (!StudentList.contains(StudentId)) {
//            return ResponseEntity.badRequest().body("Student number is not in this course.");
//        }
//        StudentList.removeIf(id -> id.equals(StudentId));
//        registrarList = registrarList.stream()
//                .filter(registrar -> !(registrar.getCourseNumber().equals(CourseNumber) && registrar.getStudentId().equals(StudentId)))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(registrarList);
//    }
}
