/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import java.util.ArrayList;

/**
 *
 * @author ingale.r
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (Type.MARKETPLACE_ORG == type){
            organization = new MarketplaceOrg(Type.MARKETPLACE_ORG.name());
            organizationList.add(organization);
        }
        else if (Type.MUNICIPAL_WASTE_PROCESSING_ORG == type){
            organization = new MunicipalWasteProcessingOrg(Type.MUNICIPAL_WASTE_PROCESSING_ORG.name());
            organizationList.add(organization);
        }
        return organization;
    }
    
    public Organization findOrganizationByType(Type type){
        for(Organization organization: this.getOrganizationList()){
            if (type.equals(organization.getType()))
                return organization; 
        }
        return null;
    }
}
