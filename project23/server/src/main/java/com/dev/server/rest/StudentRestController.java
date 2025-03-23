package com.dev.server.rest;

import com.dev.server.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudent() {

        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Palak", "nunu"));
        theStudents.add(new Student("Harsh", "dev"));
        theStudents.add(new Student("Rabindra", "Choudhary"));
        theStudents.add(new Student("Chhoti", "Kumari"));

        return theStudents;
    }

}
