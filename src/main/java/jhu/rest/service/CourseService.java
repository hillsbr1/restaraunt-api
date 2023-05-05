package jhu.rest.service;

import jhu.rest.jpa.Course;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface CourseService {

    String login(String coursename, String coursenumber);
    Optional<User> findByToken(String token);
    Course findById(Long id);
}
