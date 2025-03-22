package com.dev.server;

import com.dev.server.dao.StudentDAO;
import com.dev.server.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteStudentByLastName(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    // delete all student
    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    // delete a student by last name
    private void deleteStudentByLastName(StudentDAO studentDAO) {
        int noOfRowsAffected = studentDAO.deleteByLastname("Wayne");
        System.out.println("Deleting... ");
        System.out.println("No of rows affected: " + noOfRowsAffected);
    }

    // delete a student
    private void deleteStudent(StudentDAO studentDAO) {

        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    // update a student
    private void updateStudent(StudentDAO studentDAO) {

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Nunja"
        System.out.println("Updating student ...");
        myStudent.setFirstName("Nunji");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    // Reading from lastName
    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Nunu");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    // Read all student from database
    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    // Saving multiple student
    private void createMultipleStudent(StudentDAO studentDAO) {
        System.out.println("Creating new Student object...");
        Student tempStudent1 = new Student("Palak1", "Nunu", "nunu123@gmail.com");
        Student tempStudent2 = new Student("Harsh", "dev", "harshvirat894@gmail.com");
        Student tempStudent3 = new Student("palak2", "kumari", "palak@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        System.out.println("Saved student. Generated id: " + tempStudent1.getId());
        System.out.println("Saved student. Generated id: " + tempStudent2.getId());
        System.out.println("Saved student. Generated id: " + tempStudent3.getId());

    }

    // Saving one student
    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Palak3", "Nunu", "nunu1234@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

    // Reading from Database
    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Bruce", "Wayne", "theBatman@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());

        int theId = tempStudent.getId();
        Student myStudent = studentDAO.findById(theId);
//        Student myStudent = studentDAO.findById(tempStudent.getId());
        System.out.println("Found the Student: " + myStudent);
    }

}
