/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import TunGotTalent.Service.ServiceUser;
import TunGotTalent.entities.User;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HPENVY
 */
public class test {
    public static void main(String[] args){
     ServiceUser ser = new  ServiceUser ();
     User u1 = new User("montasser", "sellami", "aaaa", "montinho", "aaaa","homme", "1996", 10101010 ,"Administrateur" ,"Dance", "null");
     User u2 = new User("mehdi", "sellami", "aaaa", "mehdi", "aaaa","homme", "1996", 22336665 ,"Administrateur" ,"Dance", "null");
        
     try {
     // ser.ajouter(u1);
      
      
        // ser.delete(u1);
          // ser.update("amin", "null", "null", "null", "null", "null", "null",22488637, "Administrateur", "Dance", "null", 26);
            List<User> list = ser.readAll();
            System.out.println(list);
            
         // ser.Recherche_parID(99);
            
       ser.authentication ("montinho","aaaaaaaa");
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}