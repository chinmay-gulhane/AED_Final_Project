/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.common;

import com.db4o.User;
import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.enterprise.Enterprise;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.Person;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
import edu.neu.wasteManagement.ui.BaseJPanel;
import edu.neu.wasteManagement.utility.Utility;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ingale.r
 */
public class SelectOrganizationJPanel extends BaseJPanel {

    /**
     * Creates new form CreateCourseJPanel
     */
    private String selectedCity;
    private String selectedCounty;

    public SelectOrganizationJPanel(Ecosystem system) {
        super(system);
        initComponents();
        initSetup();
        populateCityTable();

        cityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                System.out.println("item state changed");
                cityComboBoxItemStateChanged(evt);
            }
        });

        countyComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                countyComboBoxItemStateChanged(evt);
            }
        });
    }

    private void populateCityTable() {
        List<City> cities = system.getCityReg().getCities();
        for (City city : cities) {
            cityComboBox.addItem(city.getName());
        }
        cityComboBox.setSelectedIndex(-1);
    }

    private void cityComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        selectedCity = (String) cityComboBox.getSelectedItem();
        populateCountyComboBox(selectedCity);
    }

    private void countyComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        selectedCounty = (String) countyComboBox.getSelectedItem();
        populateNeighComboBox(selectedCity, selectedCounty);
    }

    private void populateCountyComboBox(String selectedCity) {
        countyComboBox.removeAllItems();
        City city = system.getCityReg().findCityByName(selectedCity);
        if (city != null) {
            for (County county : city.getCounties()) {
                countyComboBox.addItem(county.getName());
            }
        }
    }

    private void populateNeighComboBox(String selectedCity, String selectedCounty) {
        neighComboBox.removeAllItems();
        City city = system.getCityReg().findCityByName(selectedCity);
        if (city != null) {
            County county = city.getCountyByName(selectedCounty);
            if (county != null) {
                for (Neighbourhood neighborhood : county.getNeighbourhoods()) {
                    neighComboBox.addItem(neighborhood.getName());
                }
            }
        }
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
        jLabel3 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbEnterprise = new javax.swing.JComboBox<>();
        cmbOrganization = new javax.swing.JComboBox<>();
        lblPassword2 = new javax.swing.JLabel();
        lblPassword3 = new javax.swing.JLabel();
        lblPassword4 = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        neighComboBox = new javax.swing.JComboBox<>();
        countyComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select an organization to proceed");

        jLabel3.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Enterprise:");

        btnSubmit.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit & Proceed");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Organization:");

        cmbEnterprise.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEnterpriseItemStateChanged(evt);
            }
        });

        lblPassword2.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblPassword2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword2.setText("Neighbourhood:");

        lblPassword3.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblPassword3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword3.setText("County:");

        lblPassword4.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        lblPassword4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPassword4.setText("City:");

        cityComboBox.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityComboBoxActionPerformed(evt);
            }
        });

        neighComboBox.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N

        countyComboBox.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        countyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countyComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPassword3, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSubmit)
                        .addComponent(neighComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOrganization, 0, 250, Short.MAX_VALUE)
                    .addComponent(countyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cityComboBox, cmbEnterprise, neighComboBox});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cmbEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblPassword4)
                        .addGap(20, 20, 20)
                        .addComponent(lblPassword2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPassword3)
                                .addComponent(countyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(neighComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(974, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (cmbOrganization.getSelectedItem() == null || cityComboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select an organization to proceed!!");
            return;
        }

        Organization org = (Organization) cmbOrganization.getSelectedItem();
        org.getUserAccountDir().associateUser(system.getLoggedInUser());
        
        String City = (String) cityComboBox.getSelectedItem();
        String Neighbourhood = (String) neighComboBox.getSelectedItem();
        String County = (String) countyComboBox.getSelectedItem();
        Neighbourhood neighbourhood = new Neighbourhood(Neighbourhood);
        system.getLoggedInUser().setNeighbourhood(neighbourhood);

        City city = new City(City);
        system.getLoggedInUser().getPerson().setCity(city);
        
        County county = new County(County);
        system.getLoggedInUser().getPerson().setCounty(county);
        
        system.getLoggedInUser().getPerson().setNeighbourhood(neighbourhood);

            
        JOptionPane.showMessageDialog(this, "Organization is now associated!!");
        
        Utility.switchPanel(system.getLoggedInUser().getRole().createWorkArea(system), system.getWorkArea());
        loginLogoutChange();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cmbEnterpriseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEnterpriseItemStateChanged
        // TODO add your handling code here:
        if (cmbEnterprise.getSelectedItem() == null) {
            return;
        }

        Enterprise ent = (Enterprise) cmbEnterprise.getSelectedItem();

        cmbOrganization.removeAllItems();
        Utility.addToComboBox(cmbOrganization, ent.getOrganizationDir().getOrganizationList());
    }//GEN-LAST:event_cmbEnterpriseItemStateChanged

    private void cityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityComboBoxActionPerformed

    private void countyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countyComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JComboBox<Enterprise> cmbEnterprise;
    private javax.swing.JComboBox<String> cmbOrganization;
    private javax.swing.JComboBox<String> countyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblPassword3;
    private javax.swing.JLabel lblPassword4;
    private javax.swing.JComboBox<String> neighComboBox;
    // End of variables declaration//GEN-END:variables

    private void initSetup() {
        Utility.addToComboBox(cmbEnterprise, system.getAllEnterprises());
    }

    private void loginLogoutChange() {
        for (Component comp : system.getHeader().getComponents()) {
            JLabel jComp = (JLabel) comp;
            if (jComp.getText().equals("Sign Up")) {
                jComp.setText("");
            }
            if (jComp.getText().equals("Log In")) {
                jComp.setText("Log Out");
            }
        }
    }

}