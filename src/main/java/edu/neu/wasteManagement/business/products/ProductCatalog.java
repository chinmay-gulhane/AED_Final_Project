/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package edu.neu.wasteManagement.business.products;
 
import java.util.ArrayList;
import java.util.List;
 
/**
*
* @author prart
*/
public class ProductCatalog {
    private List<Product> products;
 
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }
 
    public void addProduct(Product product) {
        products.add(product);
    }
 
    public List<Product> getProducts() {
        return products;
    }
}