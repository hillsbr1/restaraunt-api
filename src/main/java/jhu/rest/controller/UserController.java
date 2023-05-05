package jhu.rest.controller;

import jhu.rest.jpa.ApiUser;
import jhu.rest.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private ApiUserService apiUserService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public ApiUser getUserDetail(@PathVariable Long id){
        return apiUserService.findById(id);
    }
}
