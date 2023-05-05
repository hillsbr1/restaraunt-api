package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrarRepository extends CrudRepository<Registrar, Long> {

    @Query(value = "SELECT u FROM Registrar u where u.courseNumber = ?1 and u.studentid = ?2 ")

    Optional<Registrar> login(String coursenumber,String studentid);

    Optional<Registrar> findByToken(String token);
}
