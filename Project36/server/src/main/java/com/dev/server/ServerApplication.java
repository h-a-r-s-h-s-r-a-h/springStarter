package com.dev.server;

import com.dev.server.dao.AppDAO;
import com.dev.server.entity.Instructor;
import com.dev.server.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
            createAnotherInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        // create a new Instructor
        Instructor tempInstructor = new Instructor("Harsh", "Choudhary", "harshvirat894@gmail.com");

        // add the instructor details
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.harsh.com/youtube", "Code");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // this will also save the details object
        // because of Cascade.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void createAnotherInstructor(AppDAO appDAO) {
        // create a new Instructor
        Instructor tempInstructor = new Instructor("Palak", "Kumari", "palak@gmail.com");

        // add the instructor details
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.palak.com/youtube", "Bakwas karna");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // this will also save the details object
        // because of Cascade.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}
