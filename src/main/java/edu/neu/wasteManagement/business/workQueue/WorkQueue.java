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
public class WorkQueue {
    
    private List<WorkRequest> workRequestList;

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(List<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }
    
    public WorkRequest addWorkRequest(WorkRequest workRequest){
        
        WorkRequest request = new WorkRequest();
        workRequestList.add(request);
        return request;
        
    }
    
   
}
