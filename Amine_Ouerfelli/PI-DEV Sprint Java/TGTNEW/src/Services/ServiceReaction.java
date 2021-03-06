/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connexion.Basedonnees;
import entities.Reaction;
import interfaceservice.IServices;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceReaction implements IServices<Reaction> {
    private Connection con;
    private Statement ste;

    public ServiceReaction() {
        con = Basedonnees.getInstance().getConnection();

    }

    @Override
    public void ajouter(Reaction t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `tunisiangottalent`.`reaction` (`id_user`, `id_publication`, `type`,`date`) VALUES ('"+ t.getiduser() + "', '" + t.getidpublication() + "', '" + t.gettype() + "',NOW());";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(Reaction c) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `tunisiangottalent`.`reaction` ( `id_user`, `id_publication`, `type`,`date`) VALUES ( ?, ?, ? ,?);");
    pre.setInt(1, c.getiduser());
    pre.setInt(2,c.getidpublication());
    pre.setInt(3, c.gettype());
    pre.setDate(4, c.getdate());
    pre.executeUpdate();
    }
            

    @Override
    public boolean supprimer(Reaction t) throws SQLException 
    {
    PreparedStatement pre=con.prepareStatement("DELETE FROM `tunisiangottalent`.`reaction` where id_user= ? and id_publication= ?");
    pre.setInt(1,t.getiduser());
    pre.setInt(2, t.getidpublication());
    pre.executeUpdate();
    int rowDeleted=pre.executeUpdate();
    if(rowDeleted>0)
    {
        System.out.println("a message has been deleted");
    }
    return true;
     
    }

    @Override
    public boolean modifier(Reaction t) throws SQLException {

        String sql = "UPDATE `tunisiangottalent`.`reaction` SET type=?, date=NOW() WHERE id_user=? and id_publication=?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,t.gettype());
        statement.setInt(2,t.getiduser());
        statement.setInt(3,t.getidpublication());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing reaction was updated successfully!");
        }
        return true;
    
        
    }

    @Override
    public List<Reaction> readAll() throws SQLException {
    List<Reaction> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reaction");
     while (rs.next()) {                
               
               int id_user=rs.getInt(1);
               int id_publication=rs.getInt(2);
               int type=rs.getInt(3);
               Date date=rs.getDate(4);
               Reaction c=new Reaction(id_user,id_publication,date,type);
     arr.add(c);
     }
    return arr;
    }

    @Override
    public Reaction rechercher(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reaction> readAllsorted() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reaction> showpublicationbyuser(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatereacts(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculateups(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int calculatedowns(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reaction> showcommentsbypub(int a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
