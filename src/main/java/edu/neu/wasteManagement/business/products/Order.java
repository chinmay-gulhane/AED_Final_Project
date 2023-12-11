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
    private String seller;
    private int quantity;
    private double finalPrice;

    public Order(Product product, String buyer, String seller, int quantity,double finalPrice) {
        this.product = product;
        this.buyer = buyer;
        this.seller = seller;
        this.quantity = quantity;
        this.finalPrice = finalPrice;
    }
    
    public Order(){}


    public Product getProduct() {
        return product;
    }

    public String getBuyer() {
        return buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getSeller() {
        return seller;
    }

    
}

