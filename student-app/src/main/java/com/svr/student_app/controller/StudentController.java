package com.svr.student_app.controller;

import com.svr.student_app.dtos.StudentDto;
import com.svr.student_app.model.Student;
import com.svr.student_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/getStudents")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
    }
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto){
        Student student=new Student(studentDto.getName(),studentDto.getAge());
        studentRepository.save(student);
        return new ResponseEntity<String>("Student added successfully",HttpStatus.CREATED);
    }

}
