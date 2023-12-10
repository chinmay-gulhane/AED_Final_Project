/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.common;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.workQueue.UserWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.Waste;
import edu.neu.wasteManagement.business.workQueue.WasteProcessingRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import edu.neu.wasteManagement.ui.BaseJPanel;
import edu.neu.wasteManagement.utility.Utility;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ingale.r
 */
public class WasteProcessedJPanel extends BaseJPanel {

    /**
     * Creates new form CreateCourseJPanel
     */

    private WorkRequestType type;
    private List<Waste> wastes;
    private WorkRequest request;
    public WasteProcessedJPanel(Ecosystem system, WorkRequest request) {
        super(system);
        this.request = request;
        this.type = type;
        this.wastes = new ArrayList<>();
        initComponents();
        initSetup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWaste = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        jLabel1.setText("Waste Processed");

        btnSubmit.setBackground(new java.awt.Color(105, 155, 247));
        btnSubmit.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Mark Completed");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        tblWaste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Type", "Amount (KG)"
            }
        ));
        tblWaste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblWasteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblWaste);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(693, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        request.setStatus("Completed");
       JOptionPane.showMessageDialog(this, "Request completed!!");
       Utility.switchPanel(new ManageWasteRequestsJPanel(system), system.getWorkArea());
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void tblWasteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblWasteKeyPressed
        // TODO add your handling code here:
           if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int selectedRowIndex = tblWaste.getSelectedRow();
        
            if(selectedRowIndex < 0)
                JOptionPane.showMessageDialog(this, "Please select a row to update");
            else{
                DefaultTableModel model = (DefaultTableModel) tblWaste.getModel();
                // Get Data from table
                Waste waste = (Waste)model.getValueAt(selectedRowIndex, 0);
                Double amount = Double.parseDouble(model.getValueAt(selectedRowIndex, 1).toString());
                waste.setAmount(amount);
                JOptionPane.showMessageDialog(this, "Amount updated!!");
                
            }
        }
    }//GEN-LAST:event_tblWasteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWaste;
    // End of variables declaration//GEN-END:variables

 
    public boolean checkValidate(){
        return true;
    }

    private void initSetup() {
       populateTable();
    }
    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblWaste.getModel(); //Convert to TableModel to defaultTableModel
        model.setRowCount(0);
        
        List<Waste> wastes = null;
        
        if(request instanceof UserWasteCollectionRequest)
            wastes = ((UserWasteCollectionRequest)request).getWasteToCollect();
        else if( request instanceof WasteProcessingRequest)
            wastes = ((WasteProcessingRequest)request).getWasteToCollect();
        
        for (Waste waste : wastes) {

            //to create lines or row (row is small array of object with 3 members)
            Object[] row = new Object[2];
             row[0] = waste;
             row[1] = waste.getAmount();

            model.addRow(row);
        }
    }   

}


