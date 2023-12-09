/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.enterprise.EnterpriseType;
import edu.neu.wasteManagement.business.enterprise.MunicipalEnterprise;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.WasteCollector;
import edu.neu.wasteManagement.business.role.WasteCordinator;
import edu.neu.wasteManagement.business.role.WasteSegregator;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
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
       Enterprise greenLiving = system.getEnterpriseDir().createAndAddEnterprise("GreenLivingSolution", EnterpriseType.GREEN_LIVING_SOLUTIONS);
       
       // Create Marketplace Org
       Organization marketplace = greenLiving.getOrganizationDir().createOrganization(Type.MARKETPLACE_ORG);
       
       // Create principal User
       UserAccount andy = system.getUserAccountDir().addUserAccount("andy", "Abcd1ef", new PrincipalUser(), true);
       andy.setNeighbourhood(backbay);
       
       // Create Municipal Waste Enterprise
       Enterprise municipalWasteEnt = system.getEnterpriseDir().createAndAddEnterprise("Backbay Waste Processing Enterprise", EnterpriseType.MUNICIPAL_WASTE_SERVICES);
       ((MunicipalEnterprise)municipalWasteEnt).setHood(backbay);
       
       // Create Municipal Waste Processing org
       Organization municipalWasteOrg = municipalWasteEnt.getOrganizationDir().createOrganization(Type.MUNICIPAL_WASTE_PROCESSING_ORG);

       
       // Create Waste Cordinator for Municipal waste services:
       UserAccount wasteCordinator = system.getUserAccountDir().addUserAccount("bbwcd", "Abcd1ef", new WasteCordinator(), true);
       UserAccount wasteCollector = system.getUserAccountDir().addUserAccount("bbwcl", "Abcd1ef", new WasteCollector(), true);
       UserAccount wasteSegregator = system.getUserAccountDir().addUserAccount("bbws", "Abcd1ef", new WasteSegregator(), true);
     
       // Create Waste Collection Request
       system.createWorkRequest(WorkRequestType.USER_WASTE_COLLECTION_REQUEST,andy);
       
   }
    
}
