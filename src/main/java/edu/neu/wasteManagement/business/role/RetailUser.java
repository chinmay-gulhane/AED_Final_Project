/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.principal.PrincipalUserWorkArea;

import edu.neu.wasteManagement.ui.retail.RetailUserWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author chinmaygulhane
 */
public class RetailUser extends Role{

    public RetailUser() {
        super(RoleType.RETAIL_USER);
    }

    @Override
    public JPanel createWorkArea(Ecosystem business) {
        return new RetailUserWorkArea(business);
    }
}
