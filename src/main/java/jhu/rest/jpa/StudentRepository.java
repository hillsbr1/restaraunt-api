package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT u FROM Student u where u.id = ?1")
    Optional<Student> findStudentById(Long id);

}
