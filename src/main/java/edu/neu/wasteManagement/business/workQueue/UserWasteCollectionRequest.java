/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.business.workQueue.Waste.WasteType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class UserWasteCollectionRequest extends WorkRequest{

    public UserWasteCollectionRequest() {
        super();
        this.estimatedWasteToCollect = new ArrayList<>();
        this.actualWasteCollected = new ArrayList<>();
    }

    private Neighbourhood hood;
    private List<Waste> estimatedWasteToCollect;
    private List<Waste> actualWasteCollected;
    
    public Neighbourhood getHood() {
        return hood;
    }

    public void setHood(Neighbourhood hood) {
        this.hood = hood;
    }
    
    public void addEstimatedWasteToRequest(WasteType type, double amount){
        Waste estimatedWaste = new Waste(type, amount);
        this.estimatedWasteToCollect.add(estimatedWaste);
    }
    
    public void addActualWasteToRequest(WasteType type, double amount){
        Waste actualWaste = new Waste(type, amount);
        this.actualWasteCollected.add(actualWaste);
    }
    
    public double getWasteAmount(){
        double amount = 0;
        for(Waste actualWaste: actualWasteCollected)
            amount += actualWaste.getAmount();
        return amount;
    }
    
    
}
