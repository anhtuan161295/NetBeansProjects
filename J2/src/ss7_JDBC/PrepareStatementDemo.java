/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss7_JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class PrepareStatementDemo {
    Connection conn;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";

    public PrepareStatementDemo() {
        conn = DBConnection.getDBConnection(database, account, password);
    }
    public void dbSelect(){
        String sql = "Select * from Item";
        try {
//            Statement st = conn.createStatement();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                String code = rs.getString(1);
                String name = rs.getString("ItemName");
                int price = rs.getInt("Rate");
                System.out.println(code + "\t\t" + name + "\t\t" + price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void dbInsert(String code, String name, int price){
        String sql = "Insert into Item values (?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, code);
            st.setString(2, name);
            st.setInt(3, price);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insert successfully");
    }
    
    public void dbUpdate(String code, String name, int price){
        String sql = "Update Item set ItemName = ?, Rate = ? where ICode = ?";
                
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, price);
            st.setString(3, code);
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Update successfully");
    }
    
    public void dbDelete(String code){
        String sql = "Delete from Item where ICode = ?";
                
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, code);
            
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Delete successfully");
    }
    
    public static void main(String[] args) {
        PrepareStatementDemo test = new PrepareStatementDemo();
        test.dbDelete("test");
        test.dbSelect();
    }

}
