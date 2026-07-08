package com.test.demo.rest;

import com.test.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudents;

    @PostConstruct
    public void loadData(){
        listStudents=new ArrayList<>();

        listStudents.add(new Student("mena","caca"));
        listStudents.add(new Student("puta","lunga"));
        listStudents.add(new Student("ionel","pepsi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return listStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //check student id against list size

        if((studentId>=listStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student not found with id : " + studentId);
        }

        return listStudents.get(studentId);
    }
}
