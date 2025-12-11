package com.example.SpringBootJPAP03OneToOne.service;

import com.example.SpringBootJPAP03OneToOne.entity.Address;
import com.example.SpringBootJPAP03OneToOne.entity.Student;
import com.example.SpringBootJPAP03OneToOne.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student>getAllStudent(){
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(int id){
        Optional<Student>student= studentRepository.findById(id);
        return student.orElse(null);
    }

    public Student updateStudent(int id,Student student){
        Student student1=studentRepository.findById(id).orElse(null);
        if(student1==null){
            return null;
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
        student1.setAddress(student.getAddress());

        studentRepository.save(student1);

        return student1;
    }

    public Student updateStudentAddress(int id, Address address){
        Optional<Student>student =studentRepository.findById(id);

        if(student.isEmpty()){
            return null;
        }
        Student stud=student.get();

        stud.setAddress(address);

        return studentRepository.save(stud);
    }

    public Student deleteStudent(int id){
        Student student=studentRepository.findById(id).orElse(null);

        studentRepository.deleteById(id);

        return student;
    }







}
