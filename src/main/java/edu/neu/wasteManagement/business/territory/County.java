/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.territory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class County {
    
    private String name;
    private List<Neighbourhood> neighbourhoods;
    
    public County(String name){
        this.name = name;
        this.neighbourhoods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Neighbourhood add(String name){
        Neighbourhood hood = new Neighbourhood(name);
        this.neighbourhoods.add(hood);
        return hood;
    }
    
    public Neighbourhood get(String name){
        for(Neighbourhood hood: this.neighbourhoods)
            if(hood.getName().equals(name))
                return hood;
        return null;               
    }
}
