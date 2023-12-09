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
    
    public Organization createOrganization(String orgName, Type type){
        Organization organization = null;
        if (Type.MARKETPLACE_ORG == type){
            organization = new MarketplaceOrg(orgName, Type.MARKETPLACE_ORG);
            organizationList.add(organization);
        }
        else if (Type.MUNICIPAL_WASTE_PROCESSING_ORG == type){
            organization = new MunicipalWasteProcessingOrg(orgName, Type.MUNICIPAL_WASTE_PROCESSING_ORG);
            organizationList.add(organization);
        }
        else if (Type.REGIONAL_WASTE_MANAGEMENT_ORG == type){
            organization = new RegionalWasteManagementOrg(orgName, Type.REGIONAL_WASTE_MANAGEMENT_ORG);
            organizationList.add(organization);
        }
        organization.setType(type);
        return organization;
    }
    
    public Organization findOrganizationByType(Type type){
        for(Organization organization: this.getOrganizationList()){
            if (type.equals(organization.getType()))
                return organization; 
        }
        return null;
    }
    
    public void deleteOrganization(Organization organizationToDelete) {
        organizationList.remove(organizationToDelete);
    }
    
    public String toString(){
        String ret = "";
        for(Organization org: this.organizationList)
            ret = org + "\n";
        return "Organization Directory\n" + ret;
    }
}
