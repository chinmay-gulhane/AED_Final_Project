/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.enterprise;

import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class EnterpriseDirectory {
   
    private ArrayList<Enterprise> enterpriseList;
    
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise getEnterpriseByName(String name){
        for(Enterprise ent:this.getEnterpriseList()){
            if(ent.getName().equals(name)){
                return ent;
            }
        }
        return null;
    }
    
    public Enterprise findEnterpriseByTypeAndNeighbourhood(Neighbourhood hood, EnterpriseType type){
        for(Enterprise ent:this.getEnterpriseList()){
            if(ent.getEnterpriseType().equals(type) && ((MunicipalEnterprise)ent).getHood().equals(hood))
                return ent;
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
    
    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    public Enterprise findEnterpriseByType(EnterpriseType type){
        return null;
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,EnterpriseType type){
        Enterprise enterprise=null;
            if(type == EnterpriseType.GREEN_LIVING_SOLUTIONS){
                enterprise = new GreenLivingSolution(name,type);
                enterpriseList.add(enterprise);
            }
            else if(type == EnterpriseType.MUNICIPAL_WASTE_SERVICES){
                enterprise = new MunicipalEnterprise(name,type);
                enterpriseList.add(enterprise);
            }
//        else if(type==Enterprise.EnterpriseType.Government){
//            enterprise=new GovernmentEnterprise(name);
//            enterpriseList.add(enterprise);
//        } else if (type==Enterprise.EnterpriseType.Labour){
//            enterprise=new LabourEnterprise(name);
//            enterpriseList.add(enterprise);
//        } else if (type==Enterprise.EnterpriseType.WasteManagement){
//            enterprise= new WasteManagementEnterprise(name);
//            enterpriseList.add(enterprise);
//        } else if (type==Enterprise.EnterpriseType.MarketPlace){
//            enterprise= new WasteManagementEnterprise(name);
//            enterpriseList.add(enterprise);
//        } 
        return enterprise;
    }
    
}
