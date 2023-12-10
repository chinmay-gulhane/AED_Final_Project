/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.territory;

/**
 *
 * @author chinmaygulhane
 */
public class Neighbourhood {
    private String name;
    private County county;
    private City city;
    
    
    public Neighbourhood(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
