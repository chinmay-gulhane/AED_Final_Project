/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business;

import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.CityRegistry;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author ingale.r
 */
public class Ecosystem extends Organization{
    
    private UserAccountDirectory userAccountDir;
    private CityRegistry cityReg;
    private UserAccount loggedInUser;
    private JPanel header;
    private JPanel mainWorkArea;
    private JPanel workArea;
    private static Ecosystem instance = null;
    
    //Singleton design pattern
    public static Ecosystem getInstance(){
        if(instance == null)
            instance = new Ecosystem();
        return instance;
    }
    
    private Ecosystem(){
        super();
        this.userAccountDir = new UserAccountDirectory();
        this.cityReg = new CityRegistry();
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getMainWorkArea() {
        return mainWorkArea;
    }

    public void setMainWorkArea(JPanel mainWorkArea) {
        this.mainWorkArea = mainWorkArea;
    }

    public JPanel getWorkArea() {
        return workArea;
    }

    public void setWorkArea(JPanel workArea) {
        this.workArea = workArea;
    }

    public UserAccountDirectory getUserAccountDir() {
        return userAccountDir;
    }

    public void setUserAccountDir(UserAccountDirectory userAccountDir) {
        this.userAccountDir = userAccountDir;
    }

    public UserAccount getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserAccount loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Override
    public List<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
