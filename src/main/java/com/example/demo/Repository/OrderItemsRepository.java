package com.example.demo.Repository;

import com.example.demo.Model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository  extends JpaRepository<OrderItems,Integer> {
}
