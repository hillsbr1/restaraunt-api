package jhu.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityForARestApiApplication {

    public static void main(String[] args) {

        System.out.println("!!!!!!!!!!!!!! In springbootapp");
        
        SpringApplication.run(SpringSecurityForARestApiApplication.class, args);
    }
}
