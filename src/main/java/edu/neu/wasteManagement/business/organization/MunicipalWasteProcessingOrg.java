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
public class MunicipalWasteProcessingOrg extends Organization {

    public MunicipalWasteProcessingOrg(String name) {
        super(name);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
    
    
}
