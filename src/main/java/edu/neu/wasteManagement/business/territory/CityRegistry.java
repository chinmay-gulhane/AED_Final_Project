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

    public County getCountyByNeighbourhood(Neighbourhood hood) {
        for(City city: cities){
            County county = city.getCountyByNeighbourhood(hood);
            if(county != null)
                return county;
        }
        return null;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public County getCountyByName(String name) {
        for(City c : cities)
            if(c.countyExists(name))
                return c.getCountyByName(name);      
        return null;
    }
   
}
