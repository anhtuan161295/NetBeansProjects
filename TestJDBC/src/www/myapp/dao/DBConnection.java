/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.myapp.dao;

/**
 *
 * @author QQ
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import www.myapp.entities.User;

public class DBConnection {

    public static Connection conn = null;
    private String portNumber;
    private String username;
    private String password;
    private String database;
    private String server;
    private String url;

    public DBConnection() {
        portNumber = "1433";
        username = "sa";
        password = "123456";
        database = "Test";
        server = "localhost";
        url = "jdbc:sqlserver://" + server + ":"
                + portNumber + ";database=" + database;
    }

    public boolean setConnect() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(url, username, password);
                if (conn != null) {
                    return true;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public List<User> getList() {
        if (setConnect()) {
            try {
                PreparedStatement pst = null;
                ResultSet rs = null;
                List<User> list = new ArrayList<>();
                String sql = "Select * from Users";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setLevel(rs.getInt("level"));
                    list.add(user);

                }
                return list;
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

}
