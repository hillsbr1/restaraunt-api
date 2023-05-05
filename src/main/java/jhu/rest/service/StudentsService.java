package jhu.rest.service;

import jhu.rest.jpa.Students;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface StudentsService {

    String login(String firstname, String lastname, String dateofbirth, String email, String studentid);
    Optional<User> findByToken(String token);
    Students findById(Long id);
}
