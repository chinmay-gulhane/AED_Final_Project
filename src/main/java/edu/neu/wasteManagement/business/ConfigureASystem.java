/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.enterprise.EnterpriseType;
import edu.neu.wasteManagement.business.enterprise.MunicipalEnterprise;
import edu.neu.wasteManagement.business.enterprise.RetailWasteEnterprise;
import edu.neu.wasteManagement.business.enterprise.WasteManagementCorpEnterprise;
import edu.neu.wasteManagement.business.organization.MarketplaceOrg;
import edu.neu.wasteManagement.business.organization.MunicipalWasteProcessingOrg;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.RegionalWasteManagementOrg;
import edu.neu.wasteManagement.business.organization.RetailWasteProcessingOrg;
import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.MarketplaceIntegrator;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.RetailUser;
import edu.neu.wasteManagement.business.role.WasteCollector;
import edu.neu.wasteManagement.business.role.WasteCordinator;
import edu.neu.wasteManagement.business.role.WasteSegregator;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.workQueue.WorkRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ingale.r
 */
public class ConfigureASystem {
    
   public static Ecosystem configure(){   
       try {
           Ecosystem system = new Ecosystem();
           createData(system);
           createDataForWasteManageCorp(system);
           createDataForRetailEnterprise(system);
           return system;
       } catch (Exception ex) {
           Logger.getLogger(ConfigureASystem.class.getName()).log(Level.SEVERE, null, ex);
           return null;
       }
   }
   
   public static void createData(Ecosystem system) throws Exception{
       
       // Create Territory heirarchy
       City boston = system.getCityReg().addCity("Boston");
       County suffolk = boston.addCounty("Suffolk");
       suffolk.setCity(boston);
       Neighbourhood backbay = suffolk.addNeighbourhood("Backbay");
       backbay.setCity(boston);
       backbay.setCounty(suffolk);
       
       // Create GreenLiving Solution
       Enterprise greenLiving = system.getEnterpriseDir().createAndAddEnterprise("Green Living Solution Enterprise", EnterpriseType.GREEN_LIVING_SOLUTIONS);
       
       // Create Marketplace Org
       Organization marketplace = greenLiving.getOrganizationDir().createOrganization("Marketplace Organization",Type.MARKETPLACE_ORG);

       
        // setting up market place       
        MarketplaceOrg marketplaceOrg = (MarketplaceOrg) marketplace;

        // List a product
        marketplaceOrg.listProduct("Product 1", 20.0, 5, "sfwcl3");
        marketplaceOrg.listProduct("Product 2", 18, 4, "sfwcl3");
        marketplaceOrg.listProduct("Product 3", 10.0, 3, "sfwcl3");

       
       // Create principal User
       UserAccount andy = system.getUserAccountDir().addUserAccount("andy", "Abcd1ef", new PrincipalUser(), true);
       andy.setNeighbourhood(backbay);
       
       UserAccount retail = system.getUserAccountDir().addUserAccount("retail", "Abcd1ef", new RetailUser(), true);
       retail.setNeighbourhood(backbay);
       
       // Create Municipal Waste Enterprise
        Enterprise municipalWasteEnt = system.getEnterpriseDir().createAndAddEnterprise("Backbay Waste Processing Enterprise", EnterpriseType.MUNICIPAL_WASTE_SERVICES);
       ((MunicipalEnterprise)municipalWasteEnt).setHood(backbay);
               
       // Create Waste Management Enterprise
       Enterprise suffolkWasteManagementEnt = system.getEnterpriseDir().createAndAddEnterprise("Suffolk Waste Management Enterprise", EnterpriseType.WASTE_MANAGEMENT_CORP);
       ((WasteManagementCorpEnterprise)suffolkWasteManagementEnt).setCounty(suffolk);
              
       //Create Municiap Waste Processing org
        Organization municipalWasteOrg = municipalWasteEnt.getOrganizationDir().createOrganization("Backbay Municipal Waste Organization",Type.MUNICIPAL_WASTE_PROCESSING_ORG);
       ((MunicipalWasteProcessingOrg)municipalWasteOrg).setCounty(suffolk);
       
        // Create Regional Waste Management org
       Organization regionalWasteManagementOrg = suffolkWasteManagementEnt.getOrganizationDir().createOrganization("Suffolk Regional Waste Management Organization",Type.REGIONAL_WASTE_MANAGEMENT_ORG);
       ((RegionalWasteManagementOrg)regionalWasteManagementOrg).setCounty(suffolk);
       
       // Create Waste Cordinator for Municipal waste services:
       UserAccount wasteCordinator = system.getUserAccountDir().addUserAccount("bbwcd", "Abcd1ef", new WasteCordinator(), true); wasteCordinator.setNeighbourhood(backbay); 
       municipalWasteOrg.getUserAccountDir().associateUser(wasteCordinator);
       UserAccount wasteCollector = system.getUserAccountDir().addUserAccount("bbwcl1", "Abcd1ef", new WasteCollector(), true); wasteCollector.setNeighbourhood(backbay);
       municipalWasteOrg.getUserAccountDir().associateUser(wasteCollector);
       
       UserAccount wasteCollector2 = system.getUserAccountDir().addUserAccount("bbwcl2", "Abcd1ef", new WasteCollector(), true); wasteCollector.setNeighbourhood(backbay);
       municipalWasteOrg.getUserAccountDir().associateUser(wasteCollector2);


       UserAccount wasteSegregator = system.getUserAccountDir().addUserAccount("bbws", "Abcd1ef", new WasteSegregator(), true); wasteSegregator.setNeighbourhood(backbay);
       municipalWasteOrg.getUserAccountDir().associateUser(wasteSegregator);

     
       //  -------- Create Waste Collection Request ----------
       WorkRequest garbageCollectRequest = system.createWorkRequest(WorkRequestType.USER_WASTE_COLLECTION_REQUEST,andy);
        // Assign Waste collection Request to Waste Collector
       garbageCollectRequest.setReceiver(wasteCollector);
       
         // Waste Collector - Mark Status as completed
       garbageCollectRequest.setStatus("Completed");

       // ----------- Create Retail Waste Collection Request ----------
//       WorkRequest retailCollectRequest = system.createWorkRequest(WorkRequestType.RETAIL_WASTE_COLLECTION_REQUEST, retail);
//       retailCollectRequest.setReceiver(wasteCollector);

       // Waste Collector - Mark Status as completed
       
//       retailCollectRequest.setStatus("Completed");
     
       
       // Waste Cordinator create new Waste Processing request
       WorkRequest processingRequest = system.createWorkRequest(WorkRequestType.WASTE_PROCESSING_REQUEST, wasteCordinator);
       
       // Assign Waste Processing Request to Waste Segregator
       processingRequest.setReceiver(wasteSegregator);
        
       // Waste Collector - Mark Status as completed
       processingRequest.setStatus("Completed");
       
       
       // -------- Municipal to Waste Management -------
       
//       // Step 1 - Create MUNICIPAL_WASTE_COLLECTION_REQUEST
//       WorkRequest municipalWasteColReq = system.createWorkRequest(WorkRequestType.MUNICIPAL_WASTE_COLLECTION_REQUEST, wasteCordinator);
//       ((MunicipalWasteCollectionRequest)municipalWasteColReq).addActualWasteToRequest(Waste.WasteType.RECYCLABLE_GLASS, 15);
//       ((MunicipalWasteCollectionRequest)municipalWasteColReq).addActualWasteToRequest(Waste.WasteType.E_WASTE, 1);
//       System.out.println(regionalWasteManagementOrg.getWorkQueue());
//       
//       
//       // --------- Display the User's statistic -------
//       system.addOrganizationEnterprise(marketplace, greenLiving);
//       system.addOrganizationEnterprise(municipalWasteOrg, municipalWasteEnt);
       
       
       // Raise WCR
//     system.createWorkRequest(WorkRequestType.USER_WASTE_COLLECTION_REQUEST, andy);
             
   }
   
   private static void createDataForWasteManageCorp(Ecosystem system) throws Exception{
        //findEnterprise for WasteManagementCorp:
        County county = system.getCityReg().getCountyByName("Suffolk");
        Enterprise ent = system.getEnterpriseDir().findEnterpriseByTypeAndCounty(county, EnterpriseType.WASTE_MANAGEMENT_CORP);
        Organization org = ent.getOrganizationDir().findOrganizationByType(Type.REGIONAL_WASTE_MANAGEMENT_ORG);
        
        UserAccount wasteCordinator = system.getUserAccountDir().addUserAccount("sfwcd", "Abcd1ef", new WasteCordinator(), true);
        org.getUserAccountDir().associateUser(wasteCordinator);
        
        //Waste segregator:
        UserAccount wasteSegregator = system.getUserAccountDir().addUserAccount("sfws", "Abcd1ef", new WasteSegregator(), true);
        org.getUserAccountDir().associateUser(wasteSegregator);
        
        //Waste Collector:
        UserAccount wasteCollector = system.getUserAccountDir().addUserAccount("sfwcl", "Abcd1ef", new WasteCollector(), true);
        org.getUserAccountDir().associateUser(wasteCollector);
        
        UserAccount wasteCollector2 = system.getUserAccountDir().addUserAccount("sfwcl2", "Abcd1ef", new WasteCollector(), true);
        org.getUserAccountDir().associateUser(wasteCollector2);   
       
        
        UserAccount MarketplaceIntegrator = system.getUserAccountDir().addUserAccount("sfmi3", "Abcd1ef", new MarketplaceIntegrator(), true);
        org.getUserAccountDir().associateUser(wasteCollector2);
        // Unassigned User
        
               
       // Create Territory heirarchy
        system.getUserAccountDir().addUserAccount("jpwcd", "Abcd1ef", new WasteCordinator(), true);
   }
   
   private static void createDataForRetailEnterprise(Ecosystem system) throws Exception{
       
        Neighbourhood hood = system.getCityReg().getNeighbourhoodByName("Backbay");
        Enterprise ent = system.getEnterpriseDir().createAndAddEnterprise("Retail Waste Processing Enterprise", EnterpriseType.RETAIL_WASTE_ENTERPRISE);
       ((RetailWasteEnterprise)ent).setHood(hood);
       
        Organization retailWasteOrg = ent.getOrganizationDir().createOrganization("Backbay Retail Waste Organization",Type.RETAIL_WASTE_PROCESSING_ORG);
       ((RetailWasteProcessingOrg)retailWasteOrg).setHood(hood);
       
        //Waste segregator:
        UserAccount wasteSegregator = system.getUserAccountDir().addUserAccount("bbrws", "Abcd1ef", new WasteSegregator(), true);
        retailWasteOrg.getUserAccountDir().associateUser(wasteSegregator);
        
        //Waste Collector:
        UserAccount wasteCollector = system.getUserAccountDir().addUserAccount("bbrwcl", "Abcd1ef", new WasteCollector(), true);
        retailWasteOrg.getUserAccountDir().associateUser(wasteCollector);
        
        UserAccount wasteCordinator = system.getUserAccountDir().addUserAccount("bbrwcd", "Abcd1ef", new WasteCordinator(), true);
        retailWasteOrg.getUserAccountDir().associateUser(wasteCordinator); 
       
   }
   
    
}
