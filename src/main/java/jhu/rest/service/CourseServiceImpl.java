package jhu.rest.service;

import jhu.rest.jpa.Course;
import jhu.rest.jpa.CourseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public String login(String coursename, String coursenumber) {
 
        System.out.println ("in CourseServiceImpl - method login .... " + " coursename = " + coursename +  "   coursenumber =  " + coursenumber);

        Optional<Course> course = courseRepository.login(coursename,coursenumber);

        System.out.println("???????????????????????? course returned = " + course.toString());

        if(course.isPresent()){
            String token = UUID.randomUUID().toString();
            Course custom= course.get();
            custom.setToken(token);
            courseRepository.save(custom);

            System.out.println("%%%%%%%%%%%%%%%%%%%% token is set = " + token);

            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Course> course= courseRepository.findByToken(token);
        if(course.isPresent()){
            Course course1 = course.get();
            User user= new User(course1.getCourseName(), course1.getCoursenumber(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public Course findById(Long id) {

        System.out.println("********************    " + "in CourseServiceImpl, findByID " + "id= " + id);
        Optional<Course> course= courseRepository.findById(id);

        System.out.println("%%%%%%%%%%%%%  " + "course  = " + course.toString());
        
        return course.orElse(null);
    }
}
