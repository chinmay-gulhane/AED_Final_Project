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
    
    public City findCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null;
    }
    
    public List<County> getAllCounties() {
        List<County> allCounties = new ArrayList<>();
        for (City city : cities) {
            allCounties.addAll(city.getCounties());
        }
        return allCounties;
    }
    
    public List<Neighbourhood> getAllNeighbourhoods() {
        List<Neighbourhood> allNeighbourhoods = new ArrayList<>();
        for (City city : cities) {
            for (County county : city.getCounties()) {
                allNeighbourhoods.addAll(county.getNeighbourhoods());
            }
        }
        return allNeighbourhoods;
    }
    
    public County findCountyByName(String countyName) {
        for (City city : cities) {
            for (County county : city.getCounties()) {
                if (county.getName().equals(countyName)) {
                    return county;
                }
            }
        }
        return null;
    }

    public Neighbourhood getNeighbourhoodByName(String name) {
        for(City c : cities)
            if(c.neighbourHoodExists(name))
                return c.getNeighbourhoodByName(name);
        return null;
    }
   
}
