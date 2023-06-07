package com.example.interview_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterviewSpringApplication implements CommandLineRunner {

    @Value("${id}")
    String id;

    public static void main(String[] args) {
        SpringApplication.run(InterviewSpringApplication.class, args);
    }


    @Override
    public void run(String... arg0) {
        System.out.println(id);
    }
}
