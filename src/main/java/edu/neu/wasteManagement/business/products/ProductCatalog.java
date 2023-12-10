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
    
    public int getProductQuantity(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                return p.getQuantity();
            }
        }
        return 0; // Product not found in the catalog
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
}
