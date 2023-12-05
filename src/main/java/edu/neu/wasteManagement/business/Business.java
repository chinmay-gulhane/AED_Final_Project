/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;

/**
 *
 * @author ingale.r
 */
public class Business {
    
    private UserAccountDirectory userAccountDir;

    public UserAccountDirectory getUserAccountDir() {
        return userAccountDir;
    }

    public void setUserAccountDir(UserAccountDirectory userAccountDir) {
        this.userAccountDir = userAccountDir;
    }
    
}
