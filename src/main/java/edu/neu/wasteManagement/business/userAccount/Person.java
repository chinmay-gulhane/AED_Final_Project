/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.userAccount;

import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;

/**
 *
 * @author ingale.r
 */
public class Person {
    private String name;
    private String email;
    private Neighbourhood neighbourhood;
    private County county;
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person() {
    }
    
}
