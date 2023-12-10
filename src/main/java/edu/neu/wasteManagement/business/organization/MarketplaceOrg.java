/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import edu.neu.wasteManagement.business.products.Order;
import edu.neu.wasteManagement.business.products.Product;
import edu.neu.wasteManagement.business.products.ProductCatalog;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class MarketplaceOrg extends Organization {

    PrincipalUser user;
    //Add other users who will have access to the market
    ProductCatalog catalog;
    private List<Order> orders;

    public MarketplaceOrg(String name, Type type) {
        super(name, type);
        this.catalog = new ProductCatalog();
        this.user = new PrincipalUser();
        this.orders = new ArrayList<>();
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

    public PrincipalUser getUser() {
        return user;
    }

    public void setUser(PrincipalUser user) {
        this.user = user;
    }

    public ProductCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    public void listProduct(String productName, double price, int quantity, String username) {
        // Assuming the logged-in user is the seller
        String seller = username;
        Product product = new Product(productName, price, seller, quantity);
        catalog.addProduct(product);
        System.out.println("Product listed successfully.");
    }

    public List<Order> getUserOrders(String username) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getBuyer().equals(username)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    private int getProductQuantity(Product product) {
        // Replace with your logic to get the quantity of a product from the catalog
        return catalog.getProductQuantity(product);
    }

    private void updateProductQuantity(Product product, int quantity) {
        // Replace with your logic to update the quantity of a product in the catalog
        catalog.updateProductQuantity(product, quantity);
    }

}
