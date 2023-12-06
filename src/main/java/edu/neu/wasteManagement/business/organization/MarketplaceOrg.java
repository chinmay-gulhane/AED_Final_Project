/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import edu.neu.wasteManagement.business.products.ProductCatalog;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.Role;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class MarketplaceOrg extends Organization {
    
    PrincipalUser user;
    //Add other users who will have access to the market
    ProductCatalog catalog;

    public MarketplaceOrg() {
        this.catalog =  new ProductCatalog();
        this.user = new PrincipalUser();
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
    
    
}
