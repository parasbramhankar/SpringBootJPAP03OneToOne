package com.example.SpringBootJPAP03OneToOne.repo;

import com.example.SpringBootJPAP03OneToOne.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
