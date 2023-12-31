/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.admin.AdminWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class Admin extends Role{
    
    public Admin(){
        super(RoleType.ADMIN);
    }

    @Override
    public JPanel createWorkArea(Ecosystem business) {
        return new AdminWorkArea(business);
    }
    
}
