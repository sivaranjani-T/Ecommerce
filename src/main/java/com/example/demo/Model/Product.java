package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Product {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getShort_des() {
        return short_des;
    }

    public void setShort_des(String short_des) {
        this.short_des = short_des;
    }

    public String getLong_des() {
        return long_des;
    }

    public void setLong_des(String long_des) {
        this.long_des = long_des;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String product_name;
    private  String short_des;
    private  String long_des;
    private  Integer price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventoryId", referencedColumnName = "inventoryId")
    private Inventory inventory;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private OrderItems orderItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

}
