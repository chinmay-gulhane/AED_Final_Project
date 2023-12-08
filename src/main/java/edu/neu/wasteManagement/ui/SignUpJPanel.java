/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.wasteManagement.ui;

import edu.neu.wasteManagement.business.Ecosystem;
import edu.neu.wasteManagement.business.role.PrincipalUser;
import edu.neu.wasteManagement.business.role.RoleType;
import edu.neu.wasteManagement.business.territory.City;
import edu.neu.wasteManagement.business.territory.County;
import edu.neu.wasteManagement.business.territory.Neighbourhood;
import edu.neu.wasteManagement.business.userAccount.Person;
import edu.neu.wasteManagement.persistence.DB4OUtil;
import edu.neu.wasteManagement.utility.Validations;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ingale.r
 */
public class SignUpJPanel extends BaseJPanel {

    /**
     * Creates new form SignUpJPanel
     */
    
    private DB4OUtil dB4OUtil;
    public SignUpJPanel(Ecosystem system) {
        super(system);
        this.dB4OUtil = DB4OUtil.getInstance();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword1 = new javax.swing.JLabel();
        lblPassword2 = new javax.swing.JLabel();
        lblPassword3 = new javax.swing.JLabel();
        lblPassword4 = new javax.swing.JLabel();
        txtAddr = new javax.swing.JTextField();
        txtNeighbourhood = new javax.swing.JTextField();
        txtCounty = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        lblWelcome.setFont(new java.awt.Font("STHeiti", 1, 36)); // NOI18N
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to trashIQ !");

        lblName.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblName.setText("Name");

        txtName.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnSubmit.setBackground(new java.awt.Color(105, 155, 247));
        btnSubmit.setFont(new java.awt.Font("STHeiti", 1, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblPassword.setText("Address");

        lblPassword1.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblPassword1.setText("Password");

        lblPassword2.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblPassword2.setText("Neighbourhood");

        lblPassword3.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblPassword3.setText("County");

        lblPassword4.setFont(new java.awt.Font("STHeiti", 1, 24)); // NOI18N
        lblPassword4.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(btnSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addComponent(lblEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblPassword1)
                                    .addComponent(lblPassword2)
                                    .addComponent(lblPassword4)
                                    .addComponent(lblPassword3))
                                .addGap(3, 3, 3)))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNeighbourhood, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCounty, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 96, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtEmail, txtName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblWelcome)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword1)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPassword)
                    .addComponent(txtAddr, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPassword2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNeighbourhood)
                        .addGap(1, 1, 1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCounty, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnSubmit))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtEmail, txtName});

    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        try {
            // TODO add your handling code here:
            String name = txtName.getText();
            String email = txtEmail.getText();
            String password = txtPassword.getText();
            String address = txtAddr.getText();
            String City = txtCity.getText();
            String Neighbourhood = txtNeighbourhood.getText();
            String County = txtCounty.getText();
            
            if(!checkValidate()){
                JOptionPane.showMessageDialog(this, "Please enter valid details !!");
                return;
            }
            else 
            {system.getUserAccountDir().addUserAccount(name, password, new PrincipalUser(), true);
            Neighbourhood neighbourhood = new Neighbourhood(Neighbourhood);
            County  county = new County(County);      
            City city = new City(City);
            Person person = new Person(name,email,neighbourhood, county,city, address);
            system.getUserAccountDir().findUserAccount(name, password).setPerson(person);
            }
            
            JOptionPane.showMessageDialog(this, "Sign up completed!");
             
            clearFields();
           
        } catch (Exception ex) {
            Logger.getLogger(SignUpJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        System.out.println(system);
        dB4OUtil.storeSystem(system);
        System.out.println(system);
    }//GEN-LAST:event_btnSubmitActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPassword2;
    private javax.swing.JLabel lblPassword3;
    private javax.swing.JLabel lblPassword4;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtAddr;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCounty;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNeighbourhood;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
     
 
    public boolean checkValidate(){
        return Validations.isStringValid(txtName.getText()) &&
        Validations.isStringValid(txtEmail.getText()) &&
        Validations.isEmailValid(txtEmail.getText()) &&
        Validations.isStringValid(txtPassword.getText()) &&
        Validations.isValidPassword(txtPassword.getText());
    }
    
    public void clearFields(){
        txtName.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }

}

 

