/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.enterprise;

import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.County;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class WasteManagementCorpEnterprise extends Enterprise{
    
    private County county;
    
    public WasteManagementCorpEnterprise(){}


    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    @Override
    public List<Type> getSupportedOrganizations() {
        return null;
    }

    public WasteManagementCorpEnterprise(String name, EnterpriseType type) {
        super(name, type);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
    
    
}
