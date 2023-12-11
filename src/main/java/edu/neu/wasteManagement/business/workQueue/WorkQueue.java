/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.workQueue;

import edu.neu.wasteManagement.business.userAccount.UserAccount;
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
        
        String ret = "";
        for(WorkRequest req: this.workRequestList)
            ret += req + "\n";
        return "Work Queue Capacity: " + this.workRequestList.size() + "\n" + ret ;
    }

    public List<WorkRequest> getWorkRequestByReceiver(UserAccount loggedInUser) {
        List<WorkRequest> req = new ArrayList<>();
        for(WorkRequest request : workRequestList)
            if(request.getReceiver() != null && request.getReceiver().equals(loggedInUser))
                    req.add(request);
        return req;
    }
    
   
}
