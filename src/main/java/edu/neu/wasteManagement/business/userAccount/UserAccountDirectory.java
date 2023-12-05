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
public class UserAccountDirectory {
    private List<UserAccount> users;
    
    public UserAccountDirectory(){
        this.users = new ArrayList<UserAccount>();
    }

    public List<UserAccount> getUserAccounts() {
        return users;
    }
    
    public UserAccount addUserAccount(String username, String password, RoleType type, boolean Active) throws Exception{
        UserAccount user = new UserAccount(username, password, type, Active);
        users.add(user);
        return user;
    }
    
    public UserAccount findUserAccount(String username, String password){
        for(UserAccount user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
                return user;
        }
        return null;
                
    }
    
        public UserAccount findUserAccountByPerson(Person person){
        for(UserAccount user : users){
            if(user.getPerson().equals(person))
                return user;
        }
        return null;
                
    } 
        
   //validate logins
       public UserAccount validateLogins(String username, String password){
       for(UserAccount u:users){
           if(u.getUsername().equals(username) && BCrypt.checkpw(password,u.getPassword()))
               return u;
       }
       return null;   
   }
       
        public void deleteUserAccount(UserAccount selectedUserAccount) {
        this.users.remove(selectedUserAccount);
    }

}
