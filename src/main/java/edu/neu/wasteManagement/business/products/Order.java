/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.products;

/**
 *
 * @author chinmaygulhane
 */
public class Order {
    private Product product;
    private String buyer;
    private int quantity; // New attribute

    public Order(Product product, String buyer, int quantity) {
        this.product = product;
        this.buyer = buyer;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getBuyer() {
        return buyer;
    }

    public int getQuantity() {
        return quantity;
    }
}

