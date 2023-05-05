package jhu.rest.service;

import java.util.List;

import jhu.rest.jpa.Course;

public interface CourseService {
    Course findById(Long id);

    List<Course> getCourses();
}
