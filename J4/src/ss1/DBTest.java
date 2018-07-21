/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class DBTest {

    Connection conn;
    String database = "Stronghold";
    String account = "sa";
    String password = "123456";

    public DBTest() {
        conn = DBConnection.getDBConnection(database, account, password);
    }

    public void testConnection() {
        if (this.conn == null) {
            System.out.println("Cannot connect database " + database);
        } else {
            System.out.println("Congratulation.");
        }
    }

    public void select() {
        String sql = "Select * from Item";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString("ItemName");
                int price = rs.getInt("Rate");
                System.out.println(code + "\t\t" + name + "\t\t" + price);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dbInsert(String code, String name, int price) {
        String sql = "Insert into Item values ('" + code + "','" + name + "'," + price + ")";
        try {

            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insert successfully");
    }

    public void dbUpdate(String table, String code, String name, int price) {
        String sql = "Update " + table + " "
                + "set ItemName = '" + name + "', Rate = " + price + " "
                + "where ICode = '" + code + "'";
        try {

            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insert successfully");
    }

    public void dbDelete(String table, String code) {
        String sql = "Delete from " + table + " where ICode = '" + code + "'";
        try {

            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Insert successfully");
    }

    public static void main(String[] args) {
        DBTest test = new DBTest();
        test.testConnection();
//        test.dbDelete("Item", "AAA");
        test.select();
    }

}
