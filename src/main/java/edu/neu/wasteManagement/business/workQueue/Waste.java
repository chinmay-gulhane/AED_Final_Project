/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import java.util.List;

/**
 *
 * @author ingale.r
 */

public class Waste {

   
    public enum WasteType {
        RECYCLABLE_PAPER, RECYCLABLE_GLASS, RECYCLABLE_METAL, LANDFILL, REPURPOSED, ORGANIC, HAZARDOUS, E_WASTE, COMPOSTABLE, OTHER
    }

    private WasteType type;
    private double amount;

    public Waste(WasteType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getters and setters for type and amount
    public WasteType getType() {
        return type;
    }

    public void setType(WasteType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.type.toString();
       
    }
    

    
}
