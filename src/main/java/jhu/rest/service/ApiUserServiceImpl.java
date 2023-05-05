package jhu.rest.service;

import jhu.rest.jpa.ApiUser;
import jhu.rest.jpa.ApiUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("apiUserService")
public class ApiUserServiceImpl implements ApiUserService {

    @Autowired
    ApiUserRepository apiUserRepository;

    @Override
    public String login(String username, String password) {
 
        System.out.println ("in ApiUserServiceImpl - method login .... " + " username = " + username +  "   password =  " + password);

        Optional<ApiUser> apiuser = apiUserRepository.login(username, password);

        System.out.println("???????????????????????? apiuser returned = " + apiuser.toString());

        if(apiuser.isPresent()){
            System.out.println("apiuser is present");
            String token = UUID.randomUUID().toString();
            ApiUser custom = apiuser.get();
            custom.setToken(token);
            apiUserRepository.save(custom);

            System.out.println("%%%%%%%%%%%%%%%%%%%% token is set = " + token);

            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<ApiUser> apiUser = apiUserRepository.findByToken(token);
        if(apiUser.isPresent()){
            ApiUser apiUser1 = apiUser.get();
            User user= new User(apiUser1.getUserName(), apiUser1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public ApiUser findById(Long id) {

        System.out.println("********************    " + "in ApiUserServiceImpl, findByID " + "id= " + id);
        Optional<ApiUser> apiUser= apiUserRepository.findById(id);

        System.out.println("%%%%%%%%%%%%%  " + "apiUser  = " + apiUser.toString());
        
        return apiUser.orElse(null);
    }
}
