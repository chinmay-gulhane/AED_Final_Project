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
public class CityRegistry {
    
    private List<City> cities;
    
    public CityRegistry(){
        this.cities = new ArrayList<>();
    }

    public City addCity(String name) {
        City city = new City(name);
        this.cities.add(city);
        return city;
    }
}
