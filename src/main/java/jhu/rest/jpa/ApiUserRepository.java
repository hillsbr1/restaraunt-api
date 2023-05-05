package jhu.rest.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiUserRepository extends CrudRepository<ApiUser, Long> {

    @Query(value = "SELECT u FROM ApiUser u where u.userName = ?1 and u.password = ?2 ")

    Optional<ApiUser> login(String username,String password);

    Optional<ApiUser> findByToken(String token);
}
