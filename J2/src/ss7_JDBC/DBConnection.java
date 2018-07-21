/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss7_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author QQ
 */
public class DBConnection {
    public static Connection conn;
    public static Connection getDBConnection(String db, String acc, String pass){
        try {
            String url = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(url);
            String dbUrl = "jdbc:sqlserver://localhost;databaseName="+db;
            conn=DriverManager.getConnection(dbUrl,acc,pass);
        } catch (ClassNotFoundException | SQLException e) {
        }
         return conn;
    }
}
