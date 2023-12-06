/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import edu.neu.wasteManagement.business.workQueue.WorkQueue;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public abstract class Organization {
    
    private Type type;
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDir;
    private UserAccountDirectory userAccountDir;
    private int orgId;
    
    public abstract List<Role> getSupportedRole();
        
  
}
