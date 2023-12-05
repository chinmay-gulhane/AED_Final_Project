/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Business;
import edu.neu.wasteManagement.ui.principal.PrincipalUserWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class PrincipalUser extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Business business) {
        return new PrincipalUserWorkArea(userProcessContainer, business);
    }
    
}
