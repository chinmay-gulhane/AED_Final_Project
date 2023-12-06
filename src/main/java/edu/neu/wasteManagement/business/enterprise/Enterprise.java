/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.enterprise;

import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.OrganizationDirectory;
import edu.neu.wasteManagement.business.organization.Type;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public abstract class Enterprise extends Organization {
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDir;
    
    public abstract List<Type> getSupportedOrganizations();

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public OrganizationDirectory getOrganizationDir() {
        return organizationDir;
    }

    public void setOrganizationDir(OrganizationDirectory organizationDir) {
        this.organizationDir = organizationDir;
    }
    
    
}
