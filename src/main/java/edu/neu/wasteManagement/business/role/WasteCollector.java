/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.collector.WasteCollectorWorkArea;
import edu.neu.wasteManagement.ui.principal.PrincipalUserWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class WasteCollector extends Role{
    

    public WasteCollector(){
        super(RoleType.WASTE_COLLECTOR);
    }
    
    @Override
    public JPanel createWorkArea(Ecosystem business) {
        return new WasteCollectorWorkArea(business);
    }
    
}
