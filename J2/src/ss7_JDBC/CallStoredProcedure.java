/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss7_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import static java.sql.Types.INTEGER;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class CallStoredProcedure {
    Connection conn;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";

    public CallStoredProcedure() {
        conn = DBConnection.getDBConnection(database, account, password);
    }
    
    private void procWithoutParameter(){
        String query = "{call sp_ItemWithoutParameter}";
        CallableStatement cst;
        try {
            cst = conn.prepareCall(query);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CallStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void procWithParameter(int price){
        String query = "{call sp_ItemWithParameter(?)}";
        
        try {
            CallableStatement cst = conn.prepareCall(query);
            cst.setInt(1, price);
            ResultSet rs = cst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CallStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void procWithINOUTParameter(int price){
        String query = "{call sp_ItemWithINOUTParameter(?,?)}";
        
        try {
            CallableStatement cst = conn.prepareCall(query);
            cst.setInt(1, price);
            cst.registerOutParameter(2, INTEGER);
            cst.execute();
            
                System.out.println("Number of items: " + cst.getInt(2));
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CallStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void procWithReturnParameter(int price){
        String query = "{?=call sp_ItemWithReturnParameter(?)}";
        
        try {
            CallableStatement cst = conn.prepareCall(query);
            cst.setInt(2, price);
            cst.registerOutParameter(1, INTEGER);
            cst.execute();
            
                System.out.println("Number of items: " + cst.getInt(1));
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CallStoredProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        CallStoredProcedure test = new CallStoredProcedure();
//        test.procWithoutParameter();
//        test.procWithParameter(1200);
        test.procWithINOUTParameter(444);
//          test.procWithReturnParameter(444);
          
          
        
    }
}
