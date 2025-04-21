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
            createCourseAndReviews(appDAO);
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

    public void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    public void findCoursesWithInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        // find instructor
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        // find courses for instructor
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        // associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        // find instructor
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        // update the instructor
        System.out.println("Updating instructor id: " + theId);
        tempInstructor.setEmail("imharshvirat15@gmail.com");

        appDAO.update(tempInstructor);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 12;

        // find the course
        System.out.println("Finding the course: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);

        // update the course
        tempCourse.setTitle("Jyada bakwas karna!");

        appDAO.update(tempCourse);

        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);

        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        // create a course
        Course tempCourse = new Course("How to master Solana!");

        // add some reviews
        tempCourse.addReview(new Review("Best course ever seen!"));
        tempCourse.addReview(new Review("Cool course!"));
        tempCourse.addReview(new Review("Great course!"));

        // save the course
        appDAO.save(tempCourse);
        System.out.println("Done!");
    }
}
