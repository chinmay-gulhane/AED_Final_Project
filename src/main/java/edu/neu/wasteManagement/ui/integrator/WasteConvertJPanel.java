/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui.integrator;

import edu.neu.wasteManagement.ui.common.*;
import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.organization.MarketplaceOrg;
import edu.neu.wasteManagement.business.organization.Organization;
import edu.neu.wasteManagement.business.organization.Type;
import edu.neu.wasteManagement.business.products.Product;
import edu.neu.wasteManagement.business.products.Product.ProductType;
import edu.neu.wasteManagement.business.products.ProductCatalog;
import edu.neu.wasteManagement.business.userAccount.UserAccount;
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
public class WasteConvertJPanel extends BaseJPanel {

    /**
     * Creates new form CreateCourseJPanel
     */

    private List<Waste> wastes;
    private List<WorkRequest> requests;
    private List<Product> products;
    public WasteConvertJPanel(Ecosystem system) {
        super(system);
        this.wastes = new ArrayList<>();
        this.requests = new ArrayList<>();
        this.products = new ArrayList<>();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblWaste = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnBack3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        tblWaste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Waste Type", "Amount"
            }
        ));
        jScrollPane2.setViewportView(tblWaste);

        add(jScrollPane2);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel9.setText("Waste");

        btnAddProduct.setText(">");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnBack3.setBackground(new java.awt.Color(0, 0, 0));
        btnBack3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBack3.setForeground(new java.awt.Color(255, 255, 255));
        btnBack3.setText("Convert ?");
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });

        jLabel10.setText("Product");
        add(jLabel10);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Products", "Quantity"
            }
        ));
        jScrollPane3.setViewportView(tblProduct);

        add(jScrollPane3);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        List<Product> convertedProducts = convertWastesToProducts(wastes);
        products.addAll(convertedProducts);
        wastes = new ArrayList<>();
        populateWasteTable();
        populateProductTable();
        JOptionPane.showMessageDialog(this, "Waste converted successfully!");
        JOptionPane.showMessageDialog(this, "To lock conversion click on Convert button");
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
        // TODO add your handling code here:
        //Step 1: Fetch loggedin user
        //Step 2: Fetch loggedIn user's organization
        //Step 3 :  Fetch Product catalog form org
        //Step 4: Add the product and mark all request as Processed
        
        UserAccount user = system.getLoggedInUser();
        Organization org = system.getOrganizationByUserAccount(user);
        
        // Find marketPlace
        MarketplaceOrg marketplace = (MarketplaceOrg) system.getOrganizationByType(Type.MARKETPLACE_ORG);
        
        ProductCatalog catalog = org.getProductCatalog();
        ProductCatalog marketplaceCatalog = marketplace.getProductCatalog();
        
        for(Product p : products){
            catalog.addProduct(p);
            marketplaceCatalog.addProduct(p);
        }
        for(WorkRequest req : requests)
            req.setStatus("Processed");
        
        JOptionPane.showMessageDialog(this, "Products added to catalog successfully!!");
        Utility.switchPanel(system.getLoggedInUser().getRole().createWorkArea(system), system.getWorkArea());
        
    }//GEN-LAST:event_btnBack3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnBack3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblWaste;
    // End of variables declaration//GEN-END:variables

    private void initSetup() {
       loadWaste();
       loadRequestForWasteToBeProcessed();
       populateWasteTable();
       populateProductTable();
    }
    
    private void populateWasteTable() {
        DefaultTableModel model = (DefaultTableModel) tblWaste.getModel();
        model.setRowCount(0);   
           
           for(Waste waste : wastes){
            Object[] row = new Object[2];
            row[0] = waste;
            row[1] = waste.getAmount();

            model.addRow(row);
        }
    }

    private void populateProductTable() {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel(); 
        model.setRowCount(0);
        
        for(Product product : products){
            Object[] row = new Object[2];
            row[0] = product;
            row[1] = product.getQuantity();

            model.addRow(row);
        }
    }

    private void loadWaste() {
        List<Waste> recyclableWaste = system.getListOfRecyclableWasteForUser(system.getLoggedInUser());
        wastes.addAll(recyclableWaste);
    }

    private void loadRequestForWasteToBeProcessed() {
        List<WorkRequest> recyclableRequest = system.getListOfRecyclableRequestsForUser(system.getLoggedInUser());
        requests.addAll(recyclableRequest);
    }

    private List<Product> convertWastesToProducts(List<Waste> ws) {
        List<Product> genProducts = new ArrayList<>();
        
        for(Waste w: ws){
            Product convertedProduct = convertWasteToProduct(w);
            genProducts.add(convertedProduct);
        }
        
        return genProducts;   
    }

    private Product convertWasteToProduct(Waste w) {
        switch(w.getType()){
            case RECYCLABLE_PAPER:
                return new Product("W2P_" + ProductType.RECYCLED_PAPER.toString(), ProductType.RECYCLED_PAPER,(int)w.getAmount());
            case RECYCLABLE_GLASS:
                return new Product("W2P_" + ProductType.RECYCLED_GLASS.toString(), ProductType.RECYCLED_GLASS,(int)w.getAmount()); 
            case RECYCLABLE_METAL:
                return new Product("W2P_" + ProductType.RECYCLED_METAL.toString(), ProductType.RECYCLED_METAL,(int)w.getAmount()); 
        }
        return null;
    }


}


