/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import edu.neu.wasteManagement.business.products.ProductCatalog;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import edu.neu.wasteManagement.business.workQueue.WorkQueue;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class MunicipalWasteProcessingOrg extends Organization {

    private County county;
    
            public MunicipalWasteProcessingOrg(){}


    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
    
    public MunicipalWasteProcessingOrg(String name, Type type) {
        super(name, type);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
    
    
}
