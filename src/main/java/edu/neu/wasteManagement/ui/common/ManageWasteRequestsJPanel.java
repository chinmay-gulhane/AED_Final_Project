/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.common;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.ui.BaseJPanel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ingale.r
 */

public class ManageWasteRequestsJPanel extends BaseJPanel {

  
    public ManageWasteRequestsJPanel(Ecosystem system) {
        super(system);
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
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        chkSearchMode = new javax.swing.JCheckBox();
        txtSearchbox = new javax.swing.JTextField();
        lblEmail3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chkSearchMode1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Sender", "Reciever", "Status"
            }
        ));
        tblUser.setAutoscrolls(false);
        jScrollPane2.setViewportView(tblUser);

        btnSearch.setText("Search by ID");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewMouseClicked(evt);
            }
        });
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        chkSearchMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSearchModeActionPerformed(evt);
            }
        });

        txtSearchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchboxActionPerformed(evt);
            }
        });

        lblEmail3.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblEmail3.setText("Manage Waste Requests");

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel2.setText("Collection Request?");

        chkSearchMode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSearchMode1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Processing Request?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chkSearchMode1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addGap(0, 14083, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(lblEmail3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(7753, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7754, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(721, 721, 721)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblEmail3)
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnView)
                                .addComponent(btnDelete))
                            .addComponent(chkSearchMode1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnCancel))))
                .addContainerGap(648, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(683, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(683, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
          if (chkSearchMode.isSelected()) {
            populateTableSearch(txtSearchbox.getText());
            JOptionPane.showMessageDialog(this, "User found!");
        } else {
            JOptionPane.showMessageDialog(this, "Search-checkbox is disabled");
        } 
    }//GEN-LAST:event_btnSearchActionPerformed

    private void chkSearchModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSearchModeActionPerformed
        // TODO add your handling code here:
        if(chkSearchMode.isSelected())
        btnView.setEnabled(false);
        else
            btnView.setEnabled(true);
    }//GEN-LAST:event_chkSearchModeActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void txtSearchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchboxActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewMouseClicked
        // TODO add your handling code here:
//        btnView.setEnabled(true);
//        btnUpdate.setEnabled(true);
//        btnDelete.setEnabled(true);
//        txtnuId.setEnabled(false);
//
//        int selectedRowIndex = tblUser.getSelectedRow();
//        if (selectedRowIndex < 0) {
//            JOptionPane.showMessageDialog(this, "Select a person to View!");
//        }
//        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
//        selectedUser = (User) model.getValueAt(selectedRowIndex, 0);
//
//        txtUsername.setText(selectedUser.getUsername());
//        txtPassword.setText(selectedUser.getPassword());
//        txtnuId.setText(selectedUser.getNuId());
//        chkActive.setSelected(selectedUser.isActive());

      
    }//GEN-LAST:event_btnViewMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
//             int selectedRowIndex = tblUser.getSelectedRow();
//           if (selectedRowIndex < 0) {
//               JOptionPane.showMessageDialog(this, "Please select a row to delete!");
//           }
//           DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
//           selectedUser = (User) model.getValueAt(selectedRowIndex, 0);
//
//           business.getUserDir().deleteUser(selectedUser);
//           JOptionPane.showMessageDialog(this, "User Deleted!");
//
//           resetPage();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
//        int selectedRowIndex = tblUser.getSelectedRow();
//
//        if (selectedRowIndex < 0) {
//
//            JOptionPane.showMessageDialog(this, "Please select a row to update");
//
//        } else {
//
//            DefaultTableModel model = (DefaultTableModel) tblUser.getModel();
//            selectedUser = (User) model.getValueAt(selectedRowIndex, 0);
//
//            String userName = txtUsername.getText();
//            String password = txtPassword.getText();
//            String nuId = txtnuId.getText();
//
//            if (!checkValidate()) {
//                JOptionPane.showMessageDialog(this, "Please enter valid details");
//            } else {
//                
//                try{
//                    if(!txtPassword.getText().equals(selectedUser.getPassword()))
//                        selectedUser.setPassword(password);
//                }catch(Exception e){
//                    JOptionPane.showMessageDialog(this, e.getMessage());
//                    return;
//                }
//                selectedUser.setUsername(userName);
//                selectedUser.setActive(chkActive.isSelected());
//                
//                JOptionPane.showMessageDialog(this, "Row updated successfully");
//                resetPage();
//
//            }
//
//        } 
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        resetPage();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void chkSearchMode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSearchMode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSearchMode1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JCheckBox chkSearchMode;
    private javax.swing.JCheckBox chkSearchMode1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblEmail3;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtSearchbox;
    // End of variables declaration//GEN-END:variables

    private void initSetup() {        
          populateTable();
    }
    
       
    private void populateTable() {
    
//   DefaultTableModel model = (DefaultTableModel) tblUser.getModel(); //Convert to TableModel to defaultTableModel
//        model.setRowCount(0);
//
//        for (User user : business.getUserDir().getUsers()) {
//
//            if (user.getRole().equals("ADMIN")) {
//                continue;
//            }
//
//            //to create lines or row (row is small array of object with 3 members)
//            Object[] row = new Object[6];
//            row[0] = user;
//            row[1] = user.getUsername();
//            row[2] = user.getPassword();
//            row[3] = user.isActive();
//
//            //model will add row
//            model.addRow(row);
//        }
    }
  

  private void populateTableSearch(String nuId) {
//       DefaultTableModel model = (DefaultTableModel) tblUser.getModel(); //Convert to TableModel to defaultTableModel
//        model.setRowCount(0);
//
//        for (User user : business.getUserDir().getUsers()) {
//
//            if (!user.getNuId().equals(nuId)) {
//                continue;
//            }
//
//            //to create lines or row (row is small array of object with 3 members)
//            Object[] row = new Object[6];
//            row[0] = user;
//            row[1] = user.getUsername();
//            row[2] = user.getPassword();
//            row[3] = user.isActive();
//
//            //model will add row
//            model.addRow(row);
//        }
   
}

//      public void clearFields(){
//        txtUsername.setText("");
//        txtPassword.setText("");
//        txtnuId.setText("");     
//    }

    private void resetPage() {
        populateTable();
     //   clearFields();
        initialButtonsState();
    }

    private void initialButtonsState() {
         btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
//
//
//   public boolean checkValidate(){
//        return Validations.isStringValid(txtUsername.getText()) &&
//        Validations.isStringValid(txtPassword.getText()) && 
//        Validations.isStringValid(txtnuId.getText());
//    
//    }


}











