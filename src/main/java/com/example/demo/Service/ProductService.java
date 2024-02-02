package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.UserDto;
import com.example.demo.Model.Product;

import java.util.List;

public interface ProductService {
    String productSave(ProductDTO product);


    List<Product> searchProductsByKeyword(String keyword);
}
