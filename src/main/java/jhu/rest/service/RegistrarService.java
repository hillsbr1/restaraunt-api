package jhu.rest.service;

import jhu.rest.jpa.Registrar;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface RegistrarService {

    String login(String coursenumber, String studentid);
    Optional<User> findByToken(String token);
    Registrar findById(Long id);
}
