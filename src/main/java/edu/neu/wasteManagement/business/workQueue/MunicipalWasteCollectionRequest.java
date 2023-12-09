/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class MunicipalWasteCollectionRequest extends WorkRequest{

    private County county;
    private List<Waste> estimatedWasteToCollect;
    private List<Waste> actualWasteCollected;
    
    public MunicipalWasteCollectionRequest() {
        super();
        this.estimatedWasteToCollect = new ArrayList<>();
        this.actualWasteCollected = new ArrayList<>();
    }


    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public void addEstimatedWasteToRequest(Waste.WasteType type, double amount){
        Waste estimatedWaste = new Waste(type, amount);
        this.estimatedWasteToCollect.add(estimatedWaste);
    }
    
    public void addActualWasteToRequest(Waste.WasteType type, double amount){
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
