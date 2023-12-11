/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.organization;

import edu.neu.wasteManagement.business.products.ProductCatalog;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.userAccount.UserAccountDirectory;
import edu.neu.wasteManagement.business.workQueue.WorkQueue;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public abstract class Organization implements Serializable{
    
    private Type type;
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDir;
    private UserAccountDirectory userAccountDir;
    private ProductCatalog catalog;
    private double TrashGenerated;

    public double getTrashGenerated() {
        return TrashGenerated;
    }

    public void setTrashGenerated(double TrashGenerated) {
        this.TrashGenerated = TrashGenerated;
    }


    public UserAccountDirectory getUserAccountDir() {
        return userAccountDir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDir() {
        return employeeDir;
    }

    public void setEmployeeDir(EmployeeDirectory employeeDir) {
        this.employeeDir = employeeDir;
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public void setUserAccountDir(UserAccountDirectory userAccountDir) {
        this.userAccountDir = userAccountDir;
    }

    private int orgId;
    
    public abstract List<Role> getSupportedRole();

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Organization(String name, Type type) {
        this.name = name;
        this.type = type;
        this.workQueue = new WorkQueue();
        this.employeeDir = new EmployeeDirectory();
        this.userAccountDir = new UserAccountDirectory();
        this.catalog = new ProductCatalog();
    }

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        this.employeeDir = new EmployeeDirectory();
        this.userAccountDir = new UserAccountDirectory();
        this.catalog = new ProductCatalog();

    }    
    
    
    public Organization(){
    }
    
    public String toString(){
        return this.getName();
    }

    public ProductCatalog getProductCatalog() {
        return catalog;
    }
  
}
