/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.cordinator.WasteCordinatorWorkArea;
import edu.neu.wasteManagement.ui.principal.PrincipalUserWorkArea;
import edu.neu.wasteManagement.ui.retail.MarketplaceIntegratorWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class MarketplaceIntegrator extends Role{
    
    public MarketplaceIntegrator(){
        super(RoleType.MARKETPLACE_INTEGRATOR);
    }
    
    @Override
    public JPanel createWorkArea(Ecosystem business) {
        return new MarketplaceIntegratorWorkArea(business);
    }
    
}
