/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.common;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.workQueue.MunicipalWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.RetailWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.UserWasteCollectionRequest;
import edu.neu.wasteManagement.business.workQueue.Waste;
import edu.neu.wasteManagement.business.workQueue.WorkRequest;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import edu.neu.wasteManagement.ui.BaseJPanel;
import edu.neu.wasteManagement.utility.Utility;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



/**
 *
 * @author ingale.r
 */
public class GarbageCollectRequestJPanel extends BaseJPanel {

    /**
     * Creates new form CreateCourseJPanel
     */

    private WorkRequestType type;
    private List<Waste> wastes;
    public GarbageCollectRequestJPanel(Ecosystem system, WorkRequestType type) {
        super(system);
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
        jLabel2 = new javax.swing.JLabel();
        cmbWasteType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWaste = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txtAmt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        jLabel1.setText("Raise Request");

        btnSubmit.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit.setFont(new java.awt.Font("STHeiti", 1, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Raise Request");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("STHeiti", 0, 18)); // NOI18N
        jLabel2.setText("<html> <head> <h1>Garbage Collection Request Disclaimer</h1> </head> <body>    \n    <br><br><p>Dear Principal User,</p>\n    \n    <p>This form allows you to submit a Garbage Collection Request. Please note the following:</p>\n    \n    <ul>\n        <li>Ensure that the information provided is accurate and complete.</li>\n        <li>Attach any necessary supporting documents or details to expedite the process.</li>\n        <li>By submitting this request, you acknowledge that the information will be processed by the waste management system.</li>\n        <li>Any false or misleading information may result in delays or rejections of the request.</li>\n    </ul>\n    \n    <p>Thank you for your cooperation.</p>\n    \n    <p>Sincerely,<br>Waste Management System</p>  </body> </html> ");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Waste Type");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Amount in Kg : ");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setText("Request Summary");

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
        jScrollPane1.setViewportView(tblWaste);

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 0, 0));
        btnRemove.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        txtAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel5)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbWasteType, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addGap(30, 30, 30)
                            .addComponent(btnRemove)))
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbWasteType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnRemove))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(660, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        WorkRequest req = system.createWorkRequest(type, system.getLoggedInUser());
        addWasteToReq(req);
        JOptionPane.showMessageDialog(this, "Request raised!!");
        Utility.switchPanel(system.getLoggedInUser().getRole().createWorkArea(system), system.getWorkArea());
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        wastes.add(new Waste((Waste.WasteType) cmbWasteType.getSelectedItem(),Double.parseDouble(txtAmt.getText())));
        txtAmt.setText("");
        populateTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmtActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = tblWaste.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please Select a Row to Remove.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblWaste.getModel();
        Waste waste = (Waste) model.getValueAt(selectedRowIndex, 0);
        wastes.remove(waste);
         populateTable();
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbWasteType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWaste;
    private javax.swing.JTextField txtAmt;
    // End of variables declaration//GEN-END:variables

 
    public boolean checkValidate(){
        return true;
    }

    private void initSetup() {
        
        Utility.addToComboBox(cmbWasteType, system.getWasteType());
    }
    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) tblWaste.getModel(); //Convert to TableModel to defaultTableModel
        model.setRowCount(0);
        
        for (Waste waste : wastes) {

            //to create lines or row (row is small array of object with 3 members)
            Object[] row = new Object[2];
             row[0] = waste;
             row[1] = waste.getAmount();

            model.addRow(row);
        }
    }   

    private void addWasteToReq(WorkRequest req) {
        
        if(req instanceof UserWasteCollectionRequest)
            ((UserWasteCollectionRequest)req).addWasteToRequest(wastes);
        else if(req instanceof RetailWasteCollectionRequest)
            ((RetailWasteCollectionRequest)req).addWasteToRequest(wastes);
        else if(req instanceof MunicipalWasteCollectionRequest){
            ((MunicipalWasteCollectionRequest)req).addWasteToRequest(wastes);
        }
    }

}


