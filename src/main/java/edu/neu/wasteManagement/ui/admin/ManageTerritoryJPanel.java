/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.admin;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.ui.BaseJPanel;
import java.awt.Font;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author chinmaygulhane
 */
public class ManageTerritoryJPanel extends BaseJPanel {

    /**
     * Creates new form ManageTerritoryJPanel
     */
    public ManageTerritoryJPanel(Ecosystem system) {
        super(system);
        initComponents();
        populateCityTable();
        populateCountyTable();
        populateNeighborhoodTable();
        
    }
    
    private void populateCityTable() {
        DefaultTableModel model = (DefaultTableModel) CityTbl.getModel();
        JTableHeader header = CityTbl.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 14));
        List<City> cities = system.getCityReg().getCities();
        model.setRowCount(0);
        for (City city : cities) {
            Object[] row = new Object[4];
            row[0] = city;
            model.addRow(row);
            if (!containsItem(cityComboBox, city.getName())) {
                cityComboBox.addItem(city.getName());
            }
        }
    }

    // Method to check if an item is already present in the comboBox
    private static boolean containsItem(JComboBox<?> comboBox, Object item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (item.equals(comboBox.getItemAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    
    private void populateCountyTable() {
        DefaultTableModel model = (DefaultTableModel) CountyTbl.getModel();
        JTableHeader header = CountyTbl.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 14));
        List<County> counties = system.getCityReg().getAllCounties();
        model.setRowCount(0);
        for (County county : counties) {
            Object[] row = new Object[4];
            row[0] = county;
            row[1] = county.getCity();
            model.addRow(row);
            if (!containsItem(countyComboBox, county.getName())) {
                countyComboBox.addItem(county.getName());
            }
        }
    }
    private void populateNeighborhoodTable() {
        DefaultTableModel model = (DefaultTableModel) NeighborhoodTbl.getModel();
        JTableHeader header = NeighborhoodTbl.getTableHeader();
        header.setFont(new Font("Dialog", Font.BOLD, 14));
        List<Neighbourhood> neighbourhoods = system.getCityReg().getAllNeighbourhoods();
        System.out.println("cities"+neighbourhoods);
        model.setRowCount(0);
        for (Neighbourhood nbrhood : neighbourhoods) {
            Object[] row = new Object[4];
            row[0] = nbrhood;
            row[1] = nbrhood.getCounty();
            row[2] = nbrhood.getCity();
            model.addRow(row);
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
        jLabel73 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        btnAddCity = new javax.swing.JButton();
        btnCounty = new javax.swing.JButton();
        txtCounty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNeighborhood = new javax.swing.JTextField();
        btnAddNeigh = new javax.swing.JButton();
        countyComboBox = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        CityTbl = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        CountyTbl = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        NeighborhoodTbl = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Manage Territory");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Add CIty");

        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        btnAddCity.setBackground(new java.awt.Color(0, 0, 0));
        btnAddCity.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAddCity.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCity.setText("Add City");
        btnAddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCityActionPerformed(evt);
            }
        });

        btnCounty.setBackground(new java.awt.Color(0, 0, 0));
        btnCounty.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnCounty.setForeground(new java.awt.Color(255, 255, 255));
        btnCounty.setText("Add County");
        btnCounty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCountyActionPerformed(evt);
            }
        });

        txtCounty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountyActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Add County");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Add Neighborhood");

        txtNeighborhood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNeighborhoodActionPerformed(evt);
            }
        });

        btnAddNeigh.setBackground(new java.awt.Color(0, 0, 0));
        btnAddNeigh.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnAddNeigh.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNeigh.setText("Add Neighborhood");
        btnAddNeigh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNeighActionPerformed(evt);
            }
        });

        CityTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane7.setViewportView(CityTbl);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("City");

        CountyTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "City"
            }
        ));
        jScrollPane8.setViewportView(CountyTbl);

        NeighborhoodTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "County", "City"
            }
        ));
        jScrollPane9.setViewportView(NeighborhoodTbl);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setText("County");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel7.setText("Neighborhood");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel8.setText("Name");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("City");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel10.setText("Name:");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel11.setText("County");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel12.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddCity))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(cityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCounty)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCounty))
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(30, 30, 30)
                                .addComponent(countyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnAddNeigh)))
                        .addGap(0, 37, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cityComboBox, countyComboBox, txtCity, txtCounty, txtNeighborhood});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel73)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCity)
                    .addComponent(jLabel8)
                    .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCounty))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtNeighborhood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNeigh))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void txtCountyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountyActionPerformed

    private void txtNeighborhoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNeighborhoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNeighborhoodActionPerformed

    private void btnAddCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCityActionPerformed
        // TODO add your handling code here:
        if (txtCity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all the fields");
            return;
        }
        String newCity = txtCity.getText();
        system.getCityReg().addCity(newCity);
        populateCityTable();
    }//GEN-LAST:event_btnAddCityActionPerformed

    private void btnCountyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCountyActionPerformed
        // TODO add your handling code here:
        String cityName = (String) cityComboBox.getSelectedItem();
        City city = system.getCityReg().findCityByName(cityName);

        String countyName = txtCounty.getText();
        County newCounty = city.addCounty(countyName);
        newCounty.setCity(city);
        populateCountyTable();

    }//GEN-LAST:event_btnCountyActionPerformed

    private void btnAddNeighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNeighActionPerformed
        // TODO add your handling code here:

        String newNeighborhood = txtNeighborhood.getText();
        String countyName = (String) countyComboBox.getSelectedItem();

        County county = system.getCityReg().findCountyByName(countyName);
        Neighbourhood neighbourhood = county.addNeighbourhood(newNeighborhood);
        neighbourhood.setCounty(county);
        neighbourhood.setCity(county.getCity());
        populateNeighborhoodTable();
    }//GEN-LAST:event_btnAddNeighActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CityTbl;
    private javax.swing.JTable CountyTbl;
    private javax.swing.JTable NeighborhoodTbl;
    private javax.swing.JButton btnAddCity;
    private javax.swing.JButton btnAddNeigh;
    private javax.swing.JButton btnCounty;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JComboBox<String> countyComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCounty;
    private javax.swing.JTextField txtNeighborhood;
    // End of variables declaration//GEN-END:variables
}
