/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.wasteManagement.business.userAccount;

import edu.neu.wasteManagement.business.role.Role;
import edu.neu.wasteManagement.business.role.RoleType;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ingale.r
 */
public class UserAccount {
    private String username;
    private String password;
    private boolean Active;
    private List<String> usedPasswords;
    private Person person;
    private Role role;
    private String salt = BCrypt.gensalt();

    public UserAccount(String username, String password, Role role, boolean Active) throws Exception {
        this.usedPasswords = new ArrayList<>();
        this.username = username;
        this.setPassword(password);
        this.Active = Active;
        this.role = role;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean Active) {
        this.Active = Active;
    }
    
    
    public List<String> getUsedPasswords() {
        return usedPasswords;
    }

    public void setUsedPasswords(List<String> usedPasswords) {
        this.usedPasswords = usedPasswords;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if(!isValidPassword(password))
            throw new Exception("Invalid Password!");
      
        String hashedPassword = BCrypt.hashpw(password, salt); // Hash the password with the generated salt
        this.password = hashedPassword;
        usedPasswords.add(hashedPassword);    
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
     public boolean isValidPassword(String password){
        String pattern = "^[a-zA-Z0-9]+.*$";  // Allows letters and digits at the beginning

        if(password.equals(""))
            return false;
        
        if(password.length() < 4)
            return false;
        
        if(!password.matches(pattern))
            return false;
        
        for(String hashedPass: this.usedPasswords)
            if(BCrypt.checkpw(password, hashedPass))
                return false;
        return true;
    }
     
      public String toString(){
        return this.username;
    }
}
