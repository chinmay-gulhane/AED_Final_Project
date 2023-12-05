/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.principal;

import edu.neu.wasteManagement.business.Business;
import edu.neu.wasteManagement.ui.BaseJPanel;
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
public class PrincipalUserWorkArea extends BaseJPanel {

    public PrincipalUserWorkArea(JPanel userContainer, Business business) {
        super(business);
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

        lblProfilePic = new javax.swing.JLabel();
        lblGreetings = new javax.swing.JLabel();
        lblCourses = new javax.swing.JLabel();
        lblReviewProfessor = new javax.swing.JLabel();
        lblViewCertificates = new javax.swing.JLabel();
        lblMyGrades = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblProfilePic.setPreferredSize(new java.awt.Dimension(255, 255));

        lblGreetings.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblGreetings.setText("Hello !");

        lblCourses.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblCourses.setForeground(new java.awt.Color(0, 153, 255));
        lblCourses.setText("Visit Marketplace >");
        lblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCoursesMouseClicked(evt);
            }
        });

        lblReviewProfessor.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblReviewProfessor.setForeground(new java.awt.Color(0, 153, 255));
        lblReviewProfessor.setText("Raise Request >");
        lblReviewProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReviewProfessorMouseClicked(evt);
            }
        });

        lblViewCertificates.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblViewCertificates.setForeground(new java.awt.Color(0, 153, 255));
        lblViewCertificates.setText("Register for events >");
        lblViewCertificates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewCertificatesMouseClicked(evt);
            }
        });

        lblMyGrades.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblMyGrades.setForeground(new java.awt.Color(0, 153, 255));
        lblMyGrades.setText("See my trash >");
        lblMyGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyGradesMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        jLabel1.setText("Name : ");

        jLabel3.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        jLabel3.setText("Email id: ");

        lblName.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblName.setText("jLabel4");

        lblEmail.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblEmail.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMyGrades)
                            .addComponent(lblCourses))
                        .addGap(240, 240, 240)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblViewCertificates)
                            .addComponent(lblReviewProfessor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lblGreetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(12916, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblGreetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourses)
                            .addComponent(lblReviewProfessor))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblViewCertificates)
                            .addComponent(lblMyGrades))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblName))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblEmail))
                .addContainerGap(889, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCoursesMouseClicked
        //Mouse Click
//       Utility.switchPanel(new RegisterCourseJPanel(business), business.getWorkArea());     
    }//GEN-LAST:event_lblCoursesMouseClicked

    private void lblReviewProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReviewProfessorMouseClicked
        // TODO add your handling code here:
//       Utility.switchPanel(new ReviewProfessorJPanel(business), business.getWorkArea());
    }//GEN-LAST:event_lblReviewProfessorMouseClicked

    private void lblViewCertificatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewCertificatesMouseClicked
        // TODO add your handling code here:
//        Utility.switchPanel(new ViewCertificatesJPanel(business), business.getWorkArea());
    }//GEN-LAST:event_lblViewCertificatesMouseClicked

    private void lblMyGradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyGradesMouseClicked
        // TODO add your handling code here:
//         Utility.switchPanel(new StudentGradesJPanel(business), business.getWorkArea());     

    }//GEN-LAST:event_lblMyGradesMouseClicked
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCourses;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGreetings;
    private javax.swing.JLabel lblMyGrades;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfilePic;
    private javax.swing.JLabel lblReviewProfessor;
    private javax.swing.JLabel lblViewCertificates;
    // End of variables declaration//GEN-END:variables

    private void initialSetup() {
        // Adjust icon resolution
        
//      imageResize(lblProfilePic, "./src/edusera/assets/edusera-user-stock-profile-pic.png");
   

    }    
}
