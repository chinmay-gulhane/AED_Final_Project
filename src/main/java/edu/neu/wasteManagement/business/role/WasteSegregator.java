/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.principal.PrincipalUserWorkArea;
import edu.neu.wasteManagement.ui.segregator.WasteSegregatorWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class WasteSegregator extends Role{
    
    public WasteSegregator(){
        super(RoleType.WASTE_SEGREGATOR);
    }
    
    @Override
    public JPanel createWorkArea(Ecosystem business) {
        return new WasteSegregatorWorkArea(business);
    }
    
}
