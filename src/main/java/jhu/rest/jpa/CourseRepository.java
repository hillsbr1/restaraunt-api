package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = "SELECT c FROM Course c where c.id = ?1")
    Optional<Course> findCourseById(Long id);

    @Query(value = "SELECT * FROM Course")
    Optional<List<Course>> getCourses();
}
