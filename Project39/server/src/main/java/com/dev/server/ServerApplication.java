package com.dev.server;

import com.dev.server.dao.AppDAO;
import com.dev.server.entity.Course;
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
//            createInstructorWithCourses(appDAO);
            createAnotherInstructorWithCourses(appDAO);
        };
    }


    private void createInstructorWithCourses(AppDAO appDAO) {
        // create a new Instructor
        Instructor tempInstructor = new Instructor("Harsh", "Choudhary", "harshvirat894@gmail.com");

        // add the instructor details
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.harsh.com/youtube", "Code");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Rust for all!");
        Course tempCourse2 = new Course("Solana for only braves!");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);

        System.out.println("The courses: " + tempInstructor.getCourses());

        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void createAnotherInstructorWithCourses(AppDAO appDAO) {
        // create a new Instructor
        Instructor tempInstructor = new Instructor("Palak", "Kumari", "palakkumari@gmail.com");

        // add the instructor details
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.palak.com/youtube", "Bakwas");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Bakwas for all!");
        Course tempCourse2 = new Course("Bakwas for only braves!");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);

        System.out.println("The courses: " + tempInstructor.getCourses());

        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }


}
