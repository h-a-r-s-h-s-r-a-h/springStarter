package com.dev.server;

import com.dev.server.dao.AppDAO;
import com.dev.server.entity.Course;
import com.dev.server.entity.Instructor;
import com.dev.server.entity.InstructorDetail;
import com.dev.server.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {

        };

    }
}
