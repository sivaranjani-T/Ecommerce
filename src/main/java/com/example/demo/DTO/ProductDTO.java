package com.example.demo.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    String product_name;
    String short_des;
    String long_des;
    Integer price;
    String categoryName;
    Integer quantity;
    String location;


}
