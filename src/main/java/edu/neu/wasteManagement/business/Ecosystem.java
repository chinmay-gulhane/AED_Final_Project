/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.enterprise.EnterpriseDirectory;
import edu.neu.wasteManagement.business.enterprise.EnterpriseType;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.role.RoleType;
import edu.neu.wasteManagement.business.territory.CityRegistry;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import edu.neu.wasteManagement.business.workQueue.MunicipalWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.UserWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.WasteSegregationRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class Ecosystem extends Organization{
    
    private UserAccountDirectory userAccountDir;
    private EnterpriseDirectory enterpriseDir;

    public EnterpriseDirectory getEnterpriseDir() {
        return enterpriseDir;
    }

    public CityRegistry getCityReg() {
        return cityReg;
    }
    private CityRegistry cityReg;
    private UserAccount loggedInUser;
    private JPanel header;
    private JPanel mainWorkArea;
    private JPanel workArea;
    private static Ecosystem instance = null;
    
    //Singleton design pattern
    public static Ecosystem getInstance(){
        if(instance == null)
            instance = new Ecosystem();
        return instance;
    }
    
    private Ecosystem(){
        super("Ecosystem");
        this.userAccountDir = new UserAccountDirectory();
        this.enterpriseDir = new EnterpriseDirectory();
        this.cityReg = new CityRegistry();
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getMainWorkArea() {
        return mainWorkArea;
    }

    public void setMainWorkArea(JPanel mainWorkArea) {
        this.mainWorkArea = mainWorkArea;
    }

    public JPanel getWorkArea() {
        return workArea;
    }

    public void setWorkArea(JPanel workArea) {
        this.workArea = workArea;
    }

    public UserAccountDirectory getUserAccountDir() {
        return userAccountDir;
    }

    public void setUserAccountDir(UserAccountDirectory userAccountDir) {
        this.userAccountDir = userAccountDir;
    }

    public UserAccount getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserAccount loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Override
    public List<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public WorkRequest createWorkRequest(WorkRequestType type, UserAccount sender) {
        
        // Create request
        Organization org = null;
        WorkRequest request = null;
        UserAccount reciever = null;
        Neighbourhood hood = sender.getNeighbourhood();
        
        switch(type){
            case USER_WASTE_COLLECTION_REQUEST:
                // Create request
                request = new UserWasteCollectionRequest();
                
                // Find org
                org = findOrgByHood(hood,EnterpriseType.MUNICIPAL_WASTE_SERVICES, Type.MUNICIPAL_WASTE_PROCESSING_ORG);
                org.getWorkQueue().addWorkRequest(request);
     
                ((UserWasteCollectionRequest)request).setHood(hood); 
                break;
                
            case WASTE_PROCESSING_REQUEST:
                request = new WasteSegregationRequest();
                // Find org
                org = findOrgByHood(hood,EnterpriseType.MUNICIPAL_WASTE_SERVICES, Type.MUNICIPAL_WASTE_PROCESSING_ORG);
                // Add request to org
                org.getWorkQueue().addWorkRequest(request);                
                break;
                
            case MUNICIPAL_WASTE_COLLECTION_REQUEST:
                // Create request
                request = new MunicipalWasteCollectionRequest();
                
                // Find org
                County county = this.getCountyByNeighbourhood(hood);
                org = findOrgByCounty(county,EnterpriseType.WASTE_MANAGEMENT_CORP, Type.REGIONAL_WASTE_MANAGEMENT_ORG);
                org.getWorkQueue().addWorkRequest(request);
                
                ((MunicipalWasteCollectionRequest)request).setCounty(county); 
                break;
        }
        
        // Add request details
        request.setMessage(type.name());
        request.setRequestDate(new Date());
        request.setSender(sender);
        request.setStatus("Raised");
        
        return request;
        }
    
    
    private UserAccount findUserByNeighbourhood(Neighbourhood hood,EnterpriseType entType,Type orgType, RoleType roleType){
        return this.getEnterpriseDir()
                    .findEnterpriseByTypeAndNeighbourhood(hood, entType)
                        .getOrganizationDir().findOrganizationByType(orgType)
                            .getUserAccountDir().findUserAccountByRole(roleType);
    }

    private Organization findOrgByHood(Neighbourhood hood,EnterpriseType enterpriseType, Type type) {
        Enterprise entFound = this.getEnterpriseDir()
                    .findEnterpriseByTypeAndNeighbourhood(hood, enterpriseType);
        return entFound.getOrganizationDir().findOrganizationByType(type);
                       
    }
    
    public List<Enterprise> getAllEnterprises() {
        List<Enterprise> allEnterprises = new ArrayList<>();
        for (Enterprise enterprise : getEnterpriseDir().getEnterpriseList()) {
            allEnterprises.add(enterprise);
        }
        return allEnterprises;
    }

    public List<Organization> getAllOrganizations() {
        List<Organization> allOrganizations = new ArrayList<>();
        for (Enterprise enterprise : getEnterpriseDir().getEnterpriseList()) {
            for (Organization organization : enterprise.getOrganizationDir().getOrganizationList()) {
                allOrganizations.add(organization);
            }
        }
        return allOrganizations;
    }

    public County getCountyByNeighbourhood(Neighbourhood hood){
        return this.cityReg.getCountyByNeighbourhood(hood);
    }

    private Organization findOrgByCounty(County county, EnterpriseType enterpriseType, Type type) {
            Enterprise entFound = this.getEnterpriseDir().findEnterpriseByTypeAndCounty(county, enterpriseType);
        return entFound.getOrganizationDir().findOrganizationByType(type);
    }
}
