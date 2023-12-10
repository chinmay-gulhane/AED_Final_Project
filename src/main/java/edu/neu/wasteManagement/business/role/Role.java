/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.role;

import edu.neu.wasteManagement.business.Ecosystem;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public abstract class Role {
    private RoleType roleType;
    
    public Role(RoleType type){
        this.roleType = type;
    }
    
    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
    // Every Role must create it's own workArea
    public abstract JPanel createWorkArea(Ecosystem business);
}
