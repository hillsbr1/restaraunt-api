package jhu.rest.controller;

import jhu.rest.jpa.Course;
import jhu.rest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/api/courses/course/{id}",produces = "application/json")
    public Course getUserDetail(@PathVariable Long id){
        return courseService.findById(id);
    }

//    @PutMapping(value = "/api/courses/course/{id}",produces = "application/json")
//    public ResponseEntity updateCourse( @RequestParam(value ="CourseNumber") String CourseNumber,
//                                        @RequestParam(value ="CourseName") String CourseName,
//                                        @RequestParam(value ="id") Long id) {
//        myCourse.forEach(CourseList -> {
//            if (CourseList.getId() == id) {
//                CourseList.setCourseNumber(CourseNumber);
//                CourseList.setCourseName(CourseName);
//            }
//        });
//        return ResponseEntity.ok(myCourse);
//    }
//
//    @DeleteMapping(value = "/api/courses/course/{id}",produces = "application/json")
//    public ResponseEntity removePlaylist(@RequestParam(value ="id") Long id) {
//        Course itemToRemove = null;
//        for (Course course_list : myCourse) {
//            if (course_list.getId() == id)
//                itemToRemove = course_list;
//        }
//        myCourse.remove(itemToRemove);
//        return ResponseEntity.ok(myCourse);
//    }
}
