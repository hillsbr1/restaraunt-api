package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestaurantApplication
{
    public static void main(String[] args) {
        System.out.println("++++++++++++++++*********************");
        SpringApplication.run((Class) RestaurantApplication.class, args);
    }
}