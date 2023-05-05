package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = "SELECT u FROM Course u where u.courseName = ?1 and u.coursenumber = ?2 ")

    Optional<Course> login(String coursename,String coursenumber);

    Optional<Course> findByToken(String token);
}
