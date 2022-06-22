/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Booking_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AAUM
 */
public class Database  {
    
      public Connection getConnection() throws SQLException {
        
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String connectURL = "jdbc:sqlserver://localhost:1433;instance=DESKTOP-R1FN2EL;databaseName=Ticket_booking_System";
            java.sql.Connection con = DriverManager.getConnection(connectURL, "sa", "1234");
            
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CAN'T CONNECT TO DATABASE");
        }

        return null;
    }
    
    final public synchronized  int check_admin_log(String username, String password) {

        try {

            Connection con = getConnection();
            String qu = "select * from Admin where name = ? and password= ?";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            int id = 0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
            return id;

        } catch (Exception e) {
            return 0;
        }
    }
    
    final public synchronized  int check_user_log(String username, String password) {

        try {

            Connection con = getConnection();
            String qu = "select * from Users where name = ? and password= ?";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            int id = 0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
            return id;

        } catch (Exception e) {
            return 0;
        }
    } 
    
    
    final public synchronized  void check() throws SQLException {

        

            Connection con = getConnection();
            String qu = "select * from Admin ";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = pst.executeQuery();

            int id = 0;
            while (rs.next()) {
                id++;
                String name = rs.getString("name");
                System.out.println("Admin-name: "+name);
            }
            con.close();
            

      
    } 
    
    final public synchronized  void Create_Event(String event_name,String date,int numb_of_tickets,int admin_id) throws SQLException {
        //int adminid
        

            Connection con = getConnection();
            String qu = "insert into Events values(?,?,?,?) ";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, event_name);
            pst.setString(2, date);
            pst.setInt(3, numb_of_tickets);
            pst.setInt(4, admin_id);
            pst.executeUpdate();
            //ResultSet rs = pst.executeQuery();

            con.close();
            

      
    }
    
    final public synchronized  int Submit_details(String name,String password,String address ,String phone ) throws SQLException {
        //int adminid
        
            int exit=0;
            Connection con = getConnection();
            String qu = "insert into Users values(?,?,?,?) ";
            String qu2 = "select * from Users where name = ? ";
            PreparedStatement pst2 = con.prepareStatement(qu2, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);
             

            pst2.setString(1, name);
            

            ResultSet rs = pst2.executeQuery();

            String id = "";
            while (rs.next()) {
                id = rs.getString(2);
            }
            
            System.out.print("working--"+id);
            if(id.equals(name)){
                 exit=1;
                 
            }
            else{
                pst.setString(1, name);
                pst.setString(2, password);
                pst.setString(3, address);
                pst.setString(4, phone);

                pst.executeUpdate();
                //ResultSet rs = pst.executeQuery();

                con.close();
            }
            
            
            
            //PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);
            
            
            
            return exit;

      
    }
    
    
    
    
    final public synchronized  int BUY(int tickets,int event_id) throws SQLException {
        //int adminid
        
            int flag=0;
            Connection con = getConnection();
            String qu = "update Events set numb_of_tic =numb_of_tic-? where event_id =?";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, tickets);
            pst.setInt(2, event_id);
            pst.executeQuery();
            con.close();
            
             return flag;
           // DefaultTableModel tblmodel = (DefaultTableModel)jTable


           

      
    }
     
     final public synchronized  void Checkout(int user_id ,int admin_id,String username,int numb_of_tic,String event_name,String event_date,String seating,int event_id) throws SQLException {
        //int adminid
        

            Connection con = getConnection();
            String qu = "insert into Ticket_Checkouts values(?,?,?,?,?,?,?,?) ";
            PreparedStatement pst = con.prepareStatement(qu, Statement.RETURN_GENERATED_KEYS);
            
            pst.setInt(1, user_id);
            pst.setInt(2, admin_id);
            pst.setString(3, username);
            pst.setInt(4, numb_of_tic);
            pst.setString(5, event_name);
            pst.setString(6, event_date);
            pst.setString(7, seating);
            pst.setInt(8, event_id);
            pst.executeUpdate();
            //ResultSet rs = pst.executeQuery();

            con.close();
            

      
    }
    
    
     
    
}
