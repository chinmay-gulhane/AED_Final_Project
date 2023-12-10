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
    private List<Order> orders; 

    public ProductCatalog() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
    
    public int getProductQuantity(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                return p.getQuantity();
            }
        }
        return 0;
    }

    public void updateProductQuantity(Product product, int quantity) {
        for (Product p : products) {
            if (p.equals(product)) {
                int updatedQuantity = p.getQuantity() - quantity;
                if (updatedQuantity < 0) {
                    System.out.println("Error: Insufficient quantity available in the catalog.");
                    return;
                }
                p.setQuantity(updatedQuantity);
                return;
            }
        }
        System.out.println("Error: Product not found in the catalog.");
    }
    
    public void updateProductQuantityAfterOrder(Product product, int orderedQuantity) {
        Product existingProduct = findProductByName(product.getName());
        if (existingProduct != null) {
            int newQuantity = existingProduct.getQuantity() - orderedQuantity;
            if (newQuantity >= 0) {
                existingProduct.setQuantity(newQuantity);
            } else {
                System.out.println("Error: Insufficient quantity available in the catalog.");
            }
        } else {
            System.out.println("Error: Product not found in the catalog.");
        }
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders); 
    }
    
    public List<Order> getOrdersByUsername(String username) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getBuyer().equals(username)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
