package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
