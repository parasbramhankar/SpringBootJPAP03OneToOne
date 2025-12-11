package com.example.SpringBootJPAP03OneToOne.repo;

import com.example.SpringBootJPAP03OneToOne.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
