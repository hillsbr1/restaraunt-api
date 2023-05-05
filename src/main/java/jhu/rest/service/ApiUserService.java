package jhu.rest.service;

import jhu.rest.jpa.ApiUser;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface ApiUserService {

    String login(String username, String password);
    Optional<User> findByToken(String token);
    ApiUser findById(Long id);
}
