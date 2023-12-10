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
    private String name;
    private double price;
    private String seller;
    private int quantity; // New attribute
 
    public Product(String name, double price, String seller, int quantity) {
        this.name = name;
        this.price = price;
        this.seller = seller;
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
}