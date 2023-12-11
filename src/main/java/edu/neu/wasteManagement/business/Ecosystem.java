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
import edu.neu.wasteManagement.business.products.Product;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.role.RoleType;
import edu.neu.wasteManagement.business.territory.CityRegistry;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import edu.neu.wasteManagement.business.workQueue.MunicipalWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.RetailWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.UserWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.Waste;
import edu.neu.wasteManagement.business.workQueue.Waste.WasteType;
import edu.neu.wasteManagement.business.workQueue.WasteProcessingRequest;
import edu.neu.wasteManagement.business.workQueue.WorkQueue;
import edu.neu.wasteManagement.business.workQueue.WorkRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class Ecosystem extends Organization implements Serializable{
        
    private UserAccountDirectory userAccountDir;
    private EnterpriseDirectory enterpriseDir;
    private List<OrganizationEnterprise> organizationEnterpriseList;

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
    
    
    public Ecosystem(){
        super();
        this.userAccountDir = new UserAccountDirectory();
        this.enterpriseDir = new EnterpriseDirectory();
        this.cityReg = new CityRegistry();
        this.organizationEnterpriseList = new ArrayList<>();
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
                request = new WasteProcessingRequest();
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
                
            case RETAIL_WASTE_COLLECTION_REQUEST:
              // Create request
                request = new RetailWasteCollectionRequest();
                
                // Find org
                org = findOrgByHood(hood,EnterpriseType.RETAIL_WASTE_ENTERPRISE, Type.RETAIL_WASTE_PROCESSING_ORG);
                org.getWorkQueue().addWorkRequest(request);
                
                ((RetailWasteCollectionRequest)request).setHood(hood); 
                break;
        }
        
        // Add request details
        request.setMessage(type.name());
        request.setRequestDate(new Date());
        request.setSender(sender);
        request.setStatus("Raised");
        
        // Add request to sender queue
        sender.getQueue().addWorkRequest(request);
        
        return request;
        }
    
    

    private Organization findOrgByHood(Neighbourhood hood, EnterpriseType enterpriseType, Type type) {
        Enterprise entFound = this.getEnterpriseDir().findEnterpriseByTypeAndNeighbourhood(hood, enterpriseType);

        if (entFound != null) {
            return entFound.getOrganizationDir().findOrganizationByType(type);

        }
        return null;
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

    public double getUserNetTrashGenerated(UserAccount account) {
         double amount = 0;
         for(WorkRequest req: account.getQueue().getWorkRequestList())
             if(req instanceof UserWasteCollectionRequest )
                amount += ((UserWasteCollectionRequest)req).getWasteAmount();
         return amount;
    }
    
    public List<UserAccount> Top3UserTrash() {
    // Get all user accounts from the ecosystem
    List<UserAccount> userAccounts = this.getUserAccountDir().getUserAccounts();

    // Calculate the trash generated by each user
    for (UserAccount acc : userAccounts) {
        if(!(acc.getRole().getRoleType().equals(RoleType.PRINCIPAL_USER) || acc.getRole().getRoleType().equals(RoleType.RETAIL_USER)) )
            continue;
        double trashGenerated = getUserNetTrashGenerated(acc);
        acc.setTotalTrash(trashGenerated); // Assuming UserAccount has a method to set totalTrashGenerated
    }

    // Sort users based on the total trash generated
     Collections.sort(userAccounts, new Comparator<UserAccount>() {
            @Override
            public int compare(UserAccount u1, UserAccount u2) {
                return Double.compare(u2.getTotalTrash(), u1.getTotalTrash());
            }
        });

        // Get the top 3 users
        List<UserAccount> top3Users = new ArrayList<UserAccount>();
        for (int i = 0; i < Math.min(3, userAccounts.size()); i++) {
            top3Users.add(userAccounts.get(i));
        }

        return top3Users;
}
    
      public List<Organization> Top3OrgTrashGenerated() {
    // Get all user accounts from the ecosystem
        List<Organization> orgs = this.getAllOrganizations();

    // Calculate the trash generated by each user
    for (Organization organization : orgs) {
        double trashGenerated = getOrganizationNetTrashGenerated(organization);
        organization.setTrashGenerated(trashGenerated); // Assuming UserAccount has a method to set totalTrashGenerated
    }

    // Sort users based on the total trash generated
     Collections.sort(orgs, new Comparator<Organization>() {
            @Override
            public int compare(Organization u1, Organization u2) {
                return Double.compare(u2.getTrashGenerated(), u1.getTrashGenerated());
            }
        });

        // Get the top 3 users
        List<Organization> top3Organization = new ArrayList<Organization>();
        for (int i = 0; i < Math.min(3, orgs.size()); i++) {
            top3Organization.add(orgs.get(i));
        }

        return top3Organization;
}
   

    public double getOrganizationNetTrashGenerated(Organization org) {
        double amount = 0;
        for(WorkRequest req: org.getWorkQueue().getWorkRequestList())
             if(req instanceof MunicipalWasteCollectionRequest )
                amount += ((MunicipalWasteCollectionRequest)req).getWasteAmount();
        return amount;
    }

    public double getOrganizationNetTrashProcessed(Organization org) {
        double amount = 0;
        for(WorkRequest req: org.getWorkQueue().getWorkRequestList())
             if(req instanceof WasteProcessingRequest )
                amount += ((WasteProcessingRequest)req).getWasteAmount();
        return amount;
    }

    public boolean hasUserAssociatedWithOrganization(UserAccount loggedIn) {
        RoleType roleType = loggedIn.getRole().getRoleType();
        if(roleType.equals(RoleType.ADMIN) || roleType.equals(RoleType.PRINCIPAL_USER)) return true;
        
        for(Enterprise ent : enterpriseDir.getEnterpriseList())
            for(Organization org : ent.getOrganizationDir().getOrganizationList())
                if(org.getUserAccountDir().userAccountExists(loggedIn))
                    return true;
        return false;
    }

    public List<WasteType> getWasteType() {
      return new ArrayList<>(EnumSet.allOf(WasteType.class));  
    }

    public List<Waste> fetchListOfEmptyWasteType() {
        List<Waste> temp = new ArrayList<>();
        for(WasteType type: this.getWasteType())
            temp.add(new Waste(type,0.0));
        return temp;
    }

    public List<Waste> getListOfRecyclableWasteForUser(UserAccount user) {
        
        // Dummy list
        List<Waste> dummy = new ArrayList<>();
        
        // Get Logged In users Organization
        Organization org = this.getOrganizationByUserAccount(user);
        
        // Get WorkQueue
        WorkQueue queue = org.getWorkQueue();
        
        // Iterate over queue and select recyclable waste from processing request
        for(WorkRequest request: queue.getWorkRequestList()){
            System.out.println("Status: "+ request.getStatus() + "  Instance Of WasteProcessingRequest: " + (request instanceof WasteProcessingRequest));
            if(request.getStatus().equals("Completed") && request instanceof WasteProcessingRequest)
                for(Waste toBeRecycled: filterRecyclableWaste(((WasteProcessingRequest)request).getWasteToCollect())){
                    System.out.println("Waste Added as Recylable");
                    dummy.add(toBeRecycled);
                }
        }
        return dummy;
    }
    
    private List<Waste> filterRecyclableWaste(List<Waste> allWaste){
        List<Waste> recyclableWaste = new ArrayList<>();
        
        for(Waste waste: allWaste){
            System.out.println("Waste Type: "+ waste.getType() + "  Is it Recyclable " + (isWasteRecyclable(waste)));
            if(isWasteRecyclable(waste) && waste.getAmount() > 0){
                System.out.println("Waste Added as Recylable");
                recyclableWaste.add(waste);
            }
        }
        
        return recyclableWaste;
    }
    
    private boolean isWasteRecyclable(Waste waste){
        return waste.getType().equals(WasteType.RECYCLABLE_GLASS) 
                || waste.getType().equals(WasteType.RECYCLABLE_METAL)
                || waste.getType().equals(WasteType.RECYCLABLE_PAPER);
    }

    public List<WorkRequest> getListOfRecyclableRequestsForUser(UserAccount user) {
        // Dummy list
        List<WorkRequest> dummy = new ArrayList<>();
        
        // Get Logged In users Organization
        Organization org = this.getOrganizationByUserAccount(user);
        
        // Get WorkQueue
        WorkQueue queue = org.getWorkQueue();
        
        // Iterate over queue and select recyclable waste from processing request
        for(WorkRequest request: queue.getWorkRequestList()){
            System.out.println("Is request completed: " + request.getStatus() + "Does request contain recylclable " + processRequestContainsRecyclable(request));
            if(request.getStatus().equals("Completed") && request instanceof WasteProcessingRequest && processRequestContainsRecyclable(request)){
                System.out.println("Request Added as Recylable");
                dummy.add(request);
            }
        }
        
        return dummy;    
    }

    private boolean processRequestContainsRecyclable(WorkRequest request) {
        if(!(request instanceof WasteProcessingRequest)) 
            return false;
        for(Waste waste: ((WasteProcessingRequest)request).getWasteToCollect())
            if(isWasteRecyclable(waste))
                return true;
        return false;
    }

    public Organization getOrganizationByType(Type type) {
        for(Enterprise ent: this.getAllEnterprises())
            for(Organization org: ent.getOrganizationDir().getOrganizationList())
                if(org.getType().equals(type))
                    return org;
        return null;
    }

    public Iterable<Product> getProductsToSell(UserAccount loggedInUser) {
        Organization org = this.getOrganizationByUserAccount(loggedInUser);
        return org.getProductCatalog().getProducts();
    }
    
    public static class OrganizationEnterprise{
        public Organization org;
        public Enterprise ent;
        public OrganizationEnterprise(Organization org,Enterprise ent){
            this.org = org;
            this.ent = ent;
        }
    }
    
    public void addOrganizationEnterprise(Organization org, Enterprise ent) {
        OrganizationEnterprise organizationEnterprise = new OrganizationEnterprise(org, ent);
        organizationEnterpriseList.add(organizationEnterprise);
    }
    
    public boolean isEnterpriseLinkedToOrganization(Enterprise enterprise) {
        for (OrganizationEnterprise orgEnt : organizationEnterpriseList) {
            if (orgEnt.ent == enterprise) {
                return true;
            }
        }
        return false;
    }

    public void updateOrganizationEnterpriseLink(Organization org, Enterprise newEnt) {
        // Find the existing link for the organization
        for (OrganizationEnterprise organizationEnterprise : organizationEnterpriseList) {
            if (organizationEnterprise.org.equals(org)) {
                // Remove the existing link
                organizationEnterpriseList.remove(organizationEnterprise);
                break; // Exit the loop after removing the existing link
            }
        }

        // Add a new link with the updated enterprise
        OrganizationEnterprise newOrganizationEnterprise = new OrganizationEnterprise(org, newEnt);
        organizationEnterpriseList.add(newOrganizationEnterprise);
    }

    public void deleteOrganization(Organization organizationToDelete) {
        for (Enterprise enterprise : getEnterpriseDir().getEnterpriseList()) {
            // Using iterator to remove elements
            Iterator<Organization> iterator = enterprise.getOrganizationDir().getOrganizationList().iterator();
            while (iterator.hasNext()) {
                Organization organization = iterator.next();
                if (organization == organizationToDelete) {
                    iterator.remove();
                    break; 
                }
            }

            // Remove the organization from the organizationEnterpriseList
            removeOrganizationEnterpriseByOrganization(organizationToDelete);
        }
    }

    public void removeOrganizationEnterpriseByOrganization(Organization organizationToRemove) {
        Iterator<OrganizationEnterprise> iterator = organizationEnterpriseList.iterator();
        while (iterator.hasNext()) {
            OrganizationEnterprise orgEnt = iterator.next();
            if (orgEnt.org == organizationToRemove) {
                iterator.remove();
                break; 
            }
        }
    }

    public List<OrganizationEnterprise> fetchOrganizationForTable() {
        return organizationEnterpriseList;
    }
    
    public Organization getOrganizationByUserAccount(UserAccount user){
        //Step 1 : Iterate over all organization
        //step 2: Find provided user in organization useraccountDirectory
        //Step 3: If user found in userAccountDirectory then return organization
        
        for(Enterprise ent : enterpriseDir.getEnterpriseList()){
            for(Organization org : ent.getOrganizationDir().getOrganizationList())
                if(org.getUserAccountDir().userAccountExists(user))
                    return org;
        }
        return null;
    }

    public Enterprise findEnterpriseByName(String enterpriseName) {
        for (Enterprise enterprise : enterpriseDir.getEnterpriseList()) {
            if (enterprise.getName().equals(enterpriseName)) {
                return enterprise;
            }
        }
        return null;
    }

    public Organization findOrganizationByName(String orgName) {
        for (Enterprise enterprise : getEnterpriseDir().getEnterpriseList()) {
            for (Organization organization : enterprise.getOrganizationDir().getOrganizationList()) {
                if (organization.getName().equals(orgName)) {
                    return organization;
                }
            }
        }
        return null; // Not found
    }

    public List<OrganizationEnterprise> getOrganizationEnterpriseList() {
        return organizationEnterpriseList;
    }

    public void setOrganizationEnterpriseList(List<OrganizationEnterprise> organizationEnterpriseList) {
        this.organizationEnterpriseList = organizationEnterpriseList;
    }
    
}
