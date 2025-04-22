package com.dev.server;

import com.dev.server.dao.AppDAO;
import com.dev.server.entity.*;
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
//            createCourseAndStudents(appDAO);
//            findCourseAndStudents(appDAO);
//            findStudentAndCourses(appDAO);
//            addMoreCoursesForStudent(appDAO);\
//            deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void createCourseAndStudents(AppDAO appDAO) {

        // create a course
        Course tempCourse = new Course("Spring for all!");

        // create the students
        Student tempStudent1 = new Student("Harsh", "Bhunja", "harsh@gmail.com");
        Student tempStudent2 = new Student("Palak", "Nunja", "nunu@gmail.com");
        Student tempStudent3 = new Student("Rabindra", "Punja", "bapu@gmail.com");
        Student tempStudent4 = new Student("Chhoti", "Mazza", "mazza@gmail.com");

        // add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);
        tempCourse.addStudent(tempStudent4);

        // save the course and associated student
        System.out.println("Saving course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());


        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded course: " + tempCourse);
        System.out.println("Students enrolled in this course: " + tempCourse.getStudents());
    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

        System.out.println("Loaded student: " + tempStudent);
        System.out.println("associated courses: " + tempStudent.getCourses());
    }

    private void addMoreCoursesForStudent(AppDAO appDAO) {
        int theId = 2;

        Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Rust for all!");
        Course tempCourse2 = new Course("Fun Solana!");

        // add courses to student
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        // updating the student
        appDAO.update(tempStudent);
        System.out.println("Done!");
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting student id: " + theId);

        appDAO.deleteStudentById(theId);
        System.out.println("Done!");
    }
}
