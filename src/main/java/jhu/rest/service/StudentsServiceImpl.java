package jhu.rest.service;

import jhu.rest.jpa.Students;
import jhu.rest.jpa.StudentsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public String login(String firstname, String lastname, String dateofbirth, String email, String studentid) {
 
        System.out.println ("in StudentsServiceImpl - method login .... " + " firstname = " + firstname +  " lastname =  " + lastname + " dataofbirth = " + dateofbirth +  " email =  " + email +  " studentid = " + studentid);

        Optional<Students> students = studentsRepository.login(firstname,lastname,dateofbirth,email,studentid);

        System.out.println("???????????????????????? students returned = " + students.toString());

        if(students.isPresent()){
            String token = UUID.randomUUID().toString();
            Students custom= students.get();
            custom.setToken(token);
            studentsRepository.save(custom);

            System.out.println("%%%%%%%%%%%%%%%%%%%% token is set = " + token);

            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Students> students= studentsRepository.findByToken(token);
        if(students.isPresent()){
            Students students1 = students.get();
            User user= new User(students1.getFirstName(), students1.getLastName(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public Students findById(Long id) {

        System.out.println("********************    " + "in StudentsServiceImpl, findByID " + "id= " + id);
        Optional<Students> students= studentsRepository.findById(id);

        System.out.println("%%%%%%%%%%%%%  " + "students  = " + students.toString());
        
        return students.orElse(null);
    }
}
