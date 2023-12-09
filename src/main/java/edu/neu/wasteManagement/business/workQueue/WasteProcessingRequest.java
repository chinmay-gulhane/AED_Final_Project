/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class WasteProcessingRequest extends WorkRequest{
    
    public WasteProcessingRequest() {
        super();
        this.actualWasteProcessed = new ArrayList<>();
    }

    private Neighbourhood hood;
    private List<Waste> actualWasteProcessed;
    
    public Neighbourhood getHood() {
        return hood;
    }

    public void setHood(Neighbourhood hood) {
        this.hood = hood;
    }
    
    public void addActualWasteToRequest(Waste.WasteType type, double amount){
        Waste actualWaste = new Waste(type, amount);
        this.actualWasteProcessed.add(actualWaste);
    }
    
    public double getWasteAmount(){
        double amount = 0;
        for(Waste actualWaste: actualWasteProcessed)
            amount += actualWaste.getAmount();
        return amount;
    }
}

