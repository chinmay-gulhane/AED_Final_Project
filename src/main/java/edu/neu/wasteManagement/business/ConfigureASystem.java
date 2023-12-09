/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.enterprise.EnterpriseType;
import edu.neu.wasteManagement.business.enterprise.MunicipalEnterprise;
import edu.neu.wasteManagement.business.enterprise.WasteManagementCorpEnterprise;
import edu.neu.wasteManagement.business.organization.MunicipalWasteProcessingOrg;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.RegionalWasteManagementOrg;
import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.WasteCollector;
import edu.neu.wasteManagement.business.role.WasteCordinator;
import edu.neu.wasteManagement.business.role.WasteSegregator;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.workQueue.MunicipalWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.UserWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.Waste;
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
           Ecosystem system = Ecosystem.getInstance();
           createData(system);
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
       Neighbourhood backbay = suffolk.addNeighbourhood("Backbay");
       
       // Create GreenLiving Solution
       Enterprise greenLiving = system.getEnterpriseDir().createAndAddEnterprise("Green Living Solution Enterprise", EnterpriseType.GREEN_LIVING_SOLUTIONS);
       
       // Create Marketplace Org
       Organization marketplace = greenLiving.getOrganizationDir().createOrganization("Marketplace Organization",Type.MARKETPLACE_ORG);
       
       // Create principal User
       UserAccount andy = system.getUserAccountDir().addUserAccount("andy", "Abcd1ef", new PrincipalUser(), true);
       andy.setNeighbourhood(backbay);
       
       // Create Municipal Waste Enterprise
       Enterprise municipalWasteEnt = system.getEnterpriseDir().createAndAddEnterprise("Backbay Waste Processing Enterprise", EnterpriseType.MUNICIPAL_WASTE_SERVICES);
       ((MunicipalEnterprise)municipalWasteEnt).setHood(backbay);
        
       // Create Waste Management Enterprise
       Enterprise suffolkWasteManagementEnt = system.getEnterpriseDir().createAndAddEnterprise("Suffolk Waste Management Enterprise", EnterpriseType.WASTE_MANAGEMENT_CORP);
       ((WasteManagementCorpEnterprise)suffolkWasteManagementEnt).setCounty(suffolk);
       
       // Create Municipal Waste Processing org
       Organization municipalWasteOrg = municipalWasteEnt.getOrganizationDir().createOrganization("Suffolk Municipal Waste Organization",Type.MUNICIPAL_WASTE_PROCESSING_ORG);
       ((MunicipalWasteProcessingOrg)municipalWasteOrg).setCounty(suffolk);
       
        // Create Regional Waste Management org
       Organization regionalWasteManagementOrg = suffolkWasteManagementEnt.getOrganizationDir().createOrganization("Suffolk Regional Waste Management Organization",Type.REGIONAL_WASTE_MANAGEMENT_ORG);
       ((RegionalWasteManagementOrg)regionalWasteManagementOrg).setCounty(suffolk);
       
       // Create Waste Cordinator for Municipal waste services:
       UserAccount wasteCordinator = system.getUserAccountDir().addUserAccount("bbwcd", "Abcd1ef", new WasteCordinator(), true); wasteCordinator.setNeighbourhood(backbay);
       UserAccount wasteCollector = system.getUserAccountDir().addUserAccount("bbwcl", "Abcd1ef", new WasteCollector(), true); wasteCollector.setNeighbourhood(backbay);
       UserAccount wasteSegregator = system.getUserAccountDir().addUserAccount("bbws", "Abcd1ef", new WasteSegregator(), true); wasteSegregator.setNeighbourhood(backbay);
     
       //  -------- Create Waste Collection Request ----------
       WorkRequest garbageCollectRequest = system.createWorkRequest(WorkRequestType.USER_WASTE_COLLECTION_REQUEST,andy);
       ((UserWasteCollectionRequest)garbageCollectRequest).addActualWasteToRequest(Waste.WasteType.RECYCLABLE, 15);
       ((UserWasteCollectionRequest)garbageCollectRequest).addActualWasteToRequest(Waste.WasteType.E_WASTE, 1);

       
       // Assign Waste collection Request to Waste Collector
       garbageCollectRequest.setReceiver(wasteCollector);
       
       // Waste Collector - Mark Status as completed
       garbageCollectRequest.setStatus("Completed");
       ((UserWasteCollectionRequest)garbageCollectRequest).addActualWasteToRequest(Waste.WasteType.RECYCLABLE, 10);
       ((UserWasteCollectionRequest)garbageCollectRequest).addActualWasteToRequest(Waste.WasteType.E_WASTE, 2);

       
       // Waste Cordinator create new Waste Processing request
       WorkRequest processingRequest = system.createWorkRequest(WorkRequestType.WASTE_PROCESSING_REQUEST, wasteCordinator);
       
       // Assign Waste Processing Request to Waste Segregator
       processingRequest.setReceiver(wasteSegregator);
        
       // Waste Collector - Mark Status as completed
       processingRequest.setStatus("Completed");
       
       
       // -------- Municipal to Waste Management -------
       
       // Step 1 - Create MUNICIPAL_WASTE_COLLECTION_REQUEST
       WorkRequest municipalWasteColReq = system.createWorkRequest(WorkRequestType.MUNICIPAL_WASTE_COLLECTION_REQUEST, wasteCordinator);
       ((MunicipalWasteCollectionRequest)municipalWasteColReq).addActualWasteToRequest(Waste.WasteType.RECYCLABLE, 15);
       ((MunicipalWasteCollectionRequest)municipalWasteColReq).addActualWasteToRequest(Waste.WasteType.E_WASTE, 1);
       System.out.println(regionalWasteManagementOrg.getWorkQueue());
        
       
       // --------- Display the User's statistic -------
       System.out.println("Amount of Waste generated by " + andy.getUsername() + " is " + system.getUserNetTrashGenerated(andy));
       System.out.println("Amount of Waste generated by " + municipalWasteOrg.getName() + " is " + system.getOrganizationNetTrashGenerated(municipalWasteOrg));
       System.out.println("Amount of Waste processed by " + municipalWasteOrg.getName() + " is " + system.getOrganizationNetTrashProcessed(municipalWasteOrg));

   }
    
}
