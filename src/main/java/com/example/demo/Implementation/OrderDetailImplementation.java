package com.example.demo.Implementation;

import com.example.demo.DTO.OrderDetailsDTO;
import com.example.demo.Model.Inventory;
import com.example.demo.Model.OrderDetails;
import com.example.demo.Model.OrderItems;
import com.example.demo.Model.UserDetail;
import com.example.demo.Repository.*;
import com.example.demo.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailImplementation implements OrderDetailService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InventoryRepository inventoryRepository;



    @Override
    public String orderDetails(OrderDetailsDTO orderDetails) {
        try {
            OrderDetails newOrder=new OrderDetails();
            List<OrderItems> orderItems=new ArrayList<>();
            Integer totalPrice=0;
            for(int i=0;i<orderDetails.getOrderedItems().size();i++){
                System.out.println(i);
            OrderItems checkOrder=  orderItemsRepository.findById(orderDetails.getOrderedItems().get(i))
                        .orElseThrow(()-> new IllegalArgumentException("Orders  not found"));
            if(checkOrder.getQuantity()<=checkOrder.getProduct().getInventory().getQuantity()){
                Inventory inventory=inventoryRepository.findById(checkOrder.getProduct().getInventory().getInventoryId())
                        .orElseThrow(()-> new IllegalArgumentException("Product  not found"));
                inventory.setQuantity(checkOrder.getProduct().getInventory().getQuantity()- checkOrder.getQuantity());
                totalPrice+=checkOrder.getProduct().getPrice()*checkOrder.getQuantity();
                orderItems.add(checkOrder);
            }
            }
            UserDetail userDetail=userRepository.findById(orderDetails.getUserId())
                    .orElseThrow(()-> new IllegalArgumentException("User  not found"));

            newOrder.setOrderItemsList(orderItems);
            newOrder.setTotal(totalPrice);
            newOrder.setUserDetail(userDetail);
            orderDetailsRepository.save(newOrder);
            return "Added Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Order failed to add to cart  " + e.getMessage();
        }


    }
}
