package com.example.demo.Implementation;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Model.Inventory;
import com.example.demo.Model.Product;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.InventoryRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ProductService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductImplementation implements ProductService {
    @Autowired
    private  ProductRepository productRepository;
  @Autowired
   private CategoryRepository categoryRepository;
  @Autowired
   private InventoryRepository inventoryRepository;
    @Override
    public String productSave(ProductDTO product) {
        try {
            Product newProduct=new Product();
            newProduct.setProduct_name(product.getProduct_name());
            newProduct.setShort_des(product.getShort_des());
            newProduct.setLong_des(product.getLong_des());
            newProduct.setPrice(product.getPrice());
            newProduct.setCategory(categoryRepository.findByCategoryName(product.getCategoryName())
                    .orElseThrow(()-> new IllegalArgumentException("Category not found")));
            Inventory inventory=new Inventory();
            inventory.setQuantity(product.getQuantity());
            inventory.setLocation(product.getLocation());
            inventoryRepository.save(inventory);
            newProduct.setInventory(inventory);
            Product savedProduct=productRepository.save(newProduct);
            if (savedProduct != null) {
                return "Product saved successfully : ";
            } else {
                return "Product not saved.";
            }
        } catch (Exception e) {

            return "Failed to save product: " + e.getMessage();
        }

    }

    @Override
    public List<Product> searchProductsByKeyword(String keyword) {
      //  System.out.println(keyword);
      return  productRepository.findByProductName(keyword);
    }
  // public String deleteProduct(S)

}
