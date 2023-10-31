package com.example.demo.Controller;

import com.example.demo.DTO.UserDto;
import com.example.demo.Model.Product;
import com.example.demo.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class productController {

    @Autowired
    private ProductService productService;
    @PostMapping("save/product")
    public ResponseEntity<String> productDetails(@RequestBody Product product) {
        try {
            String result = productService.productSave(product);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to save product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    @GetMapping("/search")
//    public ResponseEntity<List<Product>> searchProductsByKeyword(@RequestParam String keyword) {
//        List<Product> products = productService.searchProductsByKeyword(keyword);
//        if (products.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }



}
