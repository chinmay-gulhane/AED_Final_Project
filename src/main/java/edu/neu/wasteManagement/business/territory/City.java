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
public class City {
    private String name;
    private List<County> counties;
    
    public City(String name){
        this.name = name;
        this.counties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public County add(String name){
        County hood = new County(name);
        this.counties.add(hood);
        return hood;
    }
    
    public County get(String name){
        for(County county: this.counties)
            if(county.getName().equals(name))
                return county;
        return null;               
    }

    public County addCounty(String name) {
        County county = new County(name);
        this.counties.add(county);
        return county;
    }
    }
