/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.enterprise;

import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class EnterpriseDirectory {
   

    private List<Enterprise> enterpriseList;
    
     public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }

    
    public ArrayList<Enterprise> getEnterpriseList() {
         return (ArrayList<Enterprise>) enterpriseList;
    }

    public Enterprise getEnterpriseByName(String name){
        for(Enterprise ent:this.getEnterpriseList()){
            if(ent.getName().equals(name)){
                return ent;
            }
        }
        return null;
    }
    
  public Enterprise findEnterpriseByTypeAndNeighbourhood(Neighbourhood hood, EnterpriseType type) {
    for (Enterprise ent : this.getEnterpriseList()) {
        if (ent.getEnterpriseType().equals(type)) {
            if (ent instanceof MunicipalEnterprise && ((MunicipalEnterprise) ent).getHood().equals(hood)) {
                return ent;
            } else if (ent instanceof RetailWasteEnterprise && ((RetailWasteEnterprise) ent).getHood().equals(hood)) {
                
                return ent;
            }
        }
    }
    return null;
}

    
    public Enterprise getEnterpriseByType(EnterpriseType type){
        for(Enterprise ent:this.getEnterpriseList()){
            if(ent.getEnterpriseType().equals(type)){
                return ent;
            }
        }
        return null;
    }
    
    
    public void setEnterpriseList(List<Enterprise> enterpriseList) {
    this.enterpriseList = enterpriseList;
}
    
   
    
    public Enterprise findEnterpriseByType(EnterpriseType type){
        return null;
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name , EnterpriseType type){
        Enterprise enterprise = null;
            if(type == EnterpriseType.GREEN_LIVING_SOLUTIONS){
                enterprise = new GreenLivingSolution(name,type);
                enterpriseList.add(enterprise);
            }
            else if(type == EnterpriseType.MUNICIPAL_WASTE_SERVICES){
                enterprise = new MunicipalEnterprise(name,type);
                enterpriseList.add(enterprise);
            }
            else if(type == EnterpriseType.WASTE_MANAGEMENT_CORP){
                enterprise = new WasteManagementCorpEnterprise(name,type);
                enterpriseList.add(enterprise);
            }
             else if(type == EnterpriseType.RETAIL_WASTE_ENTERPRISE){
                enterprise = new RetailWasteEnterprise(name,type);
                enterpriseList.add(enterprise);
            }
        return enterprise;
    }

    public Enterprise findEnterpriseByTypeAndCounty(County county, EnterpriseType type) {
        for(Enterprise ent:this.getEnterpriseList()){
            if(ent.getEnterpriseType().equals(type) && ((WasteManagementCorpEnterprise)ent).getCounty().equals(county))
                return ent;
        }
        return null;
    }

// Method to delete an enterprise by name
    public void deleteEnterpriseByName(String name) {
        Enterprise enterpriseToRemove = null;
        for (Enterprise ent : this.enterpriseList) {
            if (ent.getName().equals(name)) {
                enterpriseToRemove = ent;
                break;
            }
        }

        if (enterpriseToRemove != null) {
            this.enterpriseList.remove(enterpriseToRemove);
        }
    }

    // Method to delete an enterprise by type
    public void deleteEnterpriseByType(EnterpriseType type) {
        Enterprise enterpriseToRemove = null;
        for (Enterprise ent : this.enterpriseList) {
            if (ent.getEnterpriseType().equals(type)) {
                enterpriseToRemove = ent;
                break;
            }
        }

        if (enterpriseToRemove != null) {
            this.enterpriseList.remove(enterpriseToRemove);
        }
    }

}
