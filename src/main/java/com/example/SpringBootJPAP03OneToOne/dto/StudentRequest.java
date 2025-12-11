package com.example.SpringBootJPAP03OneToOne.dto;

import com.example.SpringBootJPAP03OneToOne.entity.Address;
import com.example.SpringBootJPAP03OneToOne.entity.Student;


public class StudentRequest {

    private String name;
    private String email;
    private int age;
    private Address address;

   public StudentRequest(){

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
