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
        this.wasteToCollect = new ArrayList<>();
    }

    private Neighbourhood hood;
    private List<Waste> wasteToCollect;

    public List<Waste> getWasteToCollect() {
        return wasteToCollect;
    }
    
    
    public Neighbourhood getHood() {
        return hood;
    }

    public void setHood(Neighbourhood hood) {
        this.hood = hood;
    }
    
    public void addWasteToRequest(List<Waste> wastes){
        this.wasteToCollect.addAll(wastes);
    }
    
    public double getWasteAmount(){
        double amount = 0;
        for(Waste actualWaste: wasteToCollect)
            amount += actualWaste.getAmount();
        return amount;
    }
    
    
}
