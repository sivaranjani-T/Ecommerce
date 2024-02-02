package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
