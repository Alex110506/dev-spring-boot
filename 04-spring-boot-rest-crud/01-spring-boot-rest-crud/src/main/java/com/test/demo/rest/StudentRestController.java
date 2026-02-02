package com.test.demo.rest;

import com.test.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents=new ArrayList<>();

        theStudents.add(new Student("mena","caca"));
        theStudents.add(new Student("puta","lunga"));
        theStudents.add(new Student("ionel","pepsi"));

        return theStudents;
    }
}
