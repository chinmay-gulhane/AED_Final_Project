/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package edu.neu.wasteManagement.business.products;
 
/**
*
* @author prart
*/
public class Product {
    
    public enum ProductType {
        RECYCLED_PAPER, RECYCLED_GLASS, RECYCLED_METAL, OTHER
    }
    
    
        public Product(){}

    private String name;
    private double price;
    private String seller;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
    private ProductType type;
    private int quantity; // New attribute
 
    public Product(String name, double price, String seller, int quantity) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        this.quantity = quantity;
    }
    
    public Product(String name,ProductType type, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }
 
    public String getName() {
        return name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public String getSeller() {
        return seller;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  name;
    } 
}