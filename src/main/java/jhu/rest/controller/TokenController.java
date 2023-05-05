package jhu.rest.controller;

import jhu.rest.service.StudentService;
import jhu.rest.service.StudentsService;
import jhu.rest.service.CourseService;
import jhu.rest.service.RegistrarService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private CourseService CourseService;
    @Autowired
    private RegistrarService RegistrarService;

    @PostMapping("/token")
    public String getToken(@RequestParam("userName") final String userName, @RequestParam("password") final String password){
       
       System.out.println("in TokenController - getToken    ....   " + userName + "      " + password) ;
       String token= studentService.login(userName,password);
       System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!      " + "=   " + token);

       if(StringUtils.isEmpty(token)){
           return "no token found"; }

       return token; }

    @PostMapping("/token/students")
    public String getStudnentsToken(@RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName,
                           @RequestParam("dateofBirth") final String dateofBirth, @RequestParam("email") final String email,
                           @RequestParam("studentId") final String studentId){

        System.out.println("in TokenController - getToken    ....   " + firstName + "      " + lastName + "  " + dateofBirth
                            + "      " + email + "    " + studentId);
        String token= studentsService.login(firstName,lastName,dateofBirth,email,studentId);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!      " + "=   " + token);

        if(StringUtils.isEmpty(token)){
            return "no token found"; }

        return token; }

    @PostMapping("/token/course")
    public String getCourseToken(@RequestParam("courseName") final String courseName, @RequestParam("coursenumber") final String coursenumber){

        System.out.println("in TokenController - getToken    ....   " + courseName + "      " + coursenumber) ;
        String token= CourseService.login(courseName,coursenumber);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!      " + "=   " + token);

        if(StringUtils.isEmpty(token)){
            return "no token found";}

        return token; }

    @PostMapping("/token/registrar")
    public String getRegistrarToken(@RequestParam("courseNumber") final String courseNumber, @RequestParam("studentid") final String studentid){

        System.out.println("in TokenController - getToken    ....   " + courseNumber + "      " + studentid) ;
        String token= RegistrarService.login(courseNumber,studentid);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!      " + "=   " + token);

        if(StringUtils.isEmpty(token)){
            return "no token found";}

        return token; }
}
