/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.enterprise;

import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class MunicipalEnterprise extends Enterprise {
    
    private Neighbourhood hood;

    public Neighbourhood getHood() {
        return hood;
    }

    public void setHood(Neighbourhood hood) {
        this.hood = hood;
    }

    @Override
    public List<Type> getSupportedOrganizations() {
        return null;
    }

    public MunicipalEnterprise(String name, EnterpriseType type) {
        super(name, type);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }
}
