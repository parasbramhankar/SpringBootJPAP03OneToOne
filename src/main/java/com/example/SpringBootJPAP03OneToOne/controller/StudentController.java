package com.example.SpringBootJPAP03OneToOne.controller;

import com.example.SpringBootJPAP03OneToOne.dto.StudentRequest;
import com.example.SpringBootJPAP03OneToOne.entity.Address;
import com.example.SpringBootJPAP03OneToOne.entity.Student;
import com.example.SpringBootJPAP03OneToOne.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping("/allStudents")
  public ResponseEntity<List<Student>>getAllStudents(){
      return ResponseEntity.ok(studentService.getAllStudent());
  }

  @PostMapping("/save")
  public ResponseEntity<Student> createStudent(@RequestBody StudentRequest request){
      Address address=request.getAddress();
      Student student=new Student(request.getName(),request.getEmail(),request.getAge(),address);

      Student student1=studentService.saveStudent(student);

      return ResponseEntity.status(HttpStatus.CREATED).body(student1);

  }

  @GetMapping("/{id}")
  public ResponseEntity<Student>findStudentById(@PathVariable int id){
      Student student=studentService.findStudentById(id);

      if(student==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      return ResponseEntity.ok(student);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String>updateStudentById(@PathVariable int id,@RequestBody StudentRequest request){
      Student stud=new Student(request.getName(), request.getEmail(), request.getAge(), request.getAddress());

      Student student=studentService.updateStudent(id,stud);

      if(student==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
      }

      return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<String>updateAddress(@PathVariable int id,@RequestBody Address address){
      Student student=studentService.updateStudentAddress(id,address);
      if(student==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
      }
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student address updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String>deleteSuccessfully(@PathVariable int id){
      Student student=studentService.deleteStudent(id);
      if(student==null){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not found");
      }
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student info delete Successfully");
  }





}
