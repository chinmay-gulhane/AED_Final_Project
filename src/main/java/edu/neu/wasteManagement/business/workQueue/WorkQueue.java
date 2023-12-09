/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ingale.r
 */
public class WorkQueue {
    
    public WorkQueue(){
        this.workRequestList = new ArrayList<>();
    }
    
    private List<WorkRequest> workRequestList;

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(List<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }
    
    public WorkRequest addWorkRequest(WorkRequest workRequest){
        workRequestList.add(workRequest);
        return workRequest;
        
    }
    
    public String toString(){
        return this.workRequestList.size() > 0 ? "Work Queue has " + this.workRequestList.size() + " requests" : "Work Queue is empty";
    }
    
   
}
