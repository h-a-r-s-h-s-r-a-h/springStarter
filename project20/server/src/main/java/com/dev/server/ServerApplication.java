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
//            createMultipleStudent(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};
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
