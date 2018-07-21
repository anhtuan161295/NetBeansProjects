/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QQ
 */
public class DBConnection {
//    public static Connection cnn;
    static String database = "VLXD";
    static String acc = "sa";
    static String pass = "123456";
    public static Connection getDBConnection(){
         // Tạo biến chứa đường dẫn kết nối SQL, chỉnh lại tên database, user, password
      String connectionUrl = "jdbc:sqlserver://localhost;" +
         "databaseName="+database+";user="+acc+";password="+pass+"";
      
      // Tạo đối tượng JDBC
      Connection cnn = null;
      
      // Thiết lập kết nối SQL
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException ex)  {
        } catch (SQLException ex) {
        }
      
        return cnn;
    }
}
