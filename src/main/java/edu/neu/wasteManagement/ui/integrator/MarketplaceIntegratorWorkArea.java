/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.integrator;

import edu.neu.wasteManagement.ui.principal.*;
import edu.neu.wasteManagement.ui.common.UserTrashJPanel;
import edu.neu.wasteManagement.ui.common.UserProfileJPanel;
import edu.neu.wasteManagement.ui.common.GarbageCollectRequestJPanel;
import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.workQueue.WorkRequestType;
import edu.neu.wasteManagement.ui.BaseJPanel;
import edu.neu.wasteManagement.ui.marketPlace.MarketPlaceHomeJPanel;
import edu.neu.wasteManagement.utility.Utility;
import static edu.neu.wasteManagement.utility.Utility.imageResize;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author ingale.r
 */
public class MarketplaceIntegratorWorkArea extends BaseJPanel {

    public MarketplaceIntegratorWorkArea(Ecosystem system) {
        super(system);
        initComponents();
        initialSetup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCourses = new javax.swing.JLabel();
        lblViewCertificates = new javax.swing.JLabel();
        lblCourses1 = new javax.swing.JLabel();
        lblMyProfile = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblCourses.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblCourses.setForeground(new java.awt.Color(0, 153, 255));
        lblCourses.setText("Visit Marketplace >");
        lblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCoursesMouseClicked(evt);
            }
        });

        lblViewCertificates.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblViewCertificates.setForeground(new java.awt.Color(0, 153, 255));
        lblViewCertificates.setText("Manage Products >");
        lblViewCertificates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewCertificatesMouseClicked(evt);
            }
        });
        lblViewCertificates.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblViewCertificatesKeyPressed(evt);
            }
        });

        lblCourses1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblCourses1.setForeground(new java.awt.Color(0, 153, 255));
        lblCourses1.setText("Waste Conversion>");
        lblCourses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCourses1MouseClicked(evt);
            }
        });

        lblMyProfile.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblMyProfile.setForeground(new java.awt.Color(0, 153, 255));
        lblMyProfile.setText("My Profile >");
        lblMyProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyProfileMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Marketplace Integrator Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourses)
                            .addComponent(lblCourses1))
                        .addGap(244, 244, 244)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMyProfile)
                            .addComponent(lblViewCertificates))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourses1)
                            .addComponent(lblMyProfile)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourses)
                            .addComponent(lblViewCertificates))))
                .addContainerGap(948, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCoursesMouseClicked
        //Mouse Click
       Utility.switchPanel(new MarketPlaceHomeJPanel(system), system.getWorkArea());    
    }//GEN-LAST:event_lblCoursesMouseClicked

    private void lblViewCertificatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewCertificatesMouseClicked
        // TODO add your handling code here:
        Utility.switchPanel(new ManageProductJPanel(system), system.getWorkArea());
    }//GEN-LAST:event_lblViewCertificatesMouseClicked

    private void lblCourses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCourses1MouseClicked
        // TODO add your handling code here:
        Utility.switchPanel(new WasteConvertJPanel(system), system.getWorkArea());
    }//GEN-LAST:event_lblCourses1MouseClicked

    private void lblViewCertificatesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblViewCertificatesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewCertificatesKeyPressed

    private void lblMyProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyProfileMouseClicked
        // TODO add your handling code here:
        Utility.switchPanel(new UserProfileJPanel(system), system.getWorkArea());
    }//GEN-LAST:event_lblMyProfileMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCourses;
    private javax.swing.JLabel lblCourses1;
    private javax.swing.JLabel lblMyProfile;
    private javax.swing.JLabel lblViewCertificates;
    // End of variables declaration//GEN-END:variables

    private void initialSetup() {
        // Adjust icon resolution
    }    
}