package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends CrudRepository<Students, Long> {

    @Query(value = "SELECT u FROM Students u where u.firstName = ?1 and u.lastName = ?2 and u.dateofBirth = ?3 and u.email = ?4 and u.studentId = ?5 ")

    Optional<Students> login(String firstname, String lastname, String dateofbirth, String email, String studentid);

    Optional<Students> findByToken(String token);
}
