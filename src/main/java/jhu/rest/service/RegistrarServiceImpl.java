package jhu.rest.service;

import jhu.rest.jpa.Registrar;
import jhu.rest.jpa.RegistrarRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("registrarService")
public class RegistrarServiceImpl implements RegistrarService {

    @Autowired
    RegistrarRepository registrarRepository;

    @Override
    public String login(String coursenumber, String studentid) {
 
        System.out.println ("in RegistrarServiceImpl - method login .... " + " coursenumber = " + coursenumber +  "   studentid =  " + studentid);

        Optional<Registrar> registrar = registrarRepository.login(coursenumber,studentid);

        System.out.println("???????????????????????? registrar returned = " + registrar.toString());

        if(registrar.isPresent()){
            String token = UUID.randomUUID().toString();
            Registrar custom= registrar.get();
            custom.setToken(token);
            registrarRepository.save(custom);

            System.out.println("%%%%%%%%%%%%%%%%%%%% token is set = " + token);

            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Registrar> registrar= registrarRepository.findByToken(token);
        if(registrar.isPresent()){
            Registrar registrar1 = registrar.get();
            User user= new User(registrar1.getCourseNumber(), registrar1.getStudentid(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public Registrar findById(Long id) {

        System.out.println("********************    " + "in RegistrarServiceImpl, findByID " + "id= " + id);
        Optional<Registrar> registrar= registrarRepository.findById(id);

        System.out.println("%%%%%%%%%%%%%  " + "registrar  = " + registrar.toString());
        
        return registrar.orElse(null);
    }
}
