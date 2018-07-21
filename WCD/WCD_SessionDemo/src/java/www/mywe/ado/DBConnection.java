/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.mywe.ado;

/**
 *
 * @author QQ
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import www.mywe.ado.User;

public class DBConnection {

    private Connection conn;
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

    public void setConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }

    public boolean checkConnection() {
        try {
            if (conn != null && conn.isValid(0)) {
                return true;
            } else if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (Exception ex) {
        }
        return false;
    }

    public List<User> getList() {
        List<User> list = new ArrayList<>();
//        setConnection();
        if (checkConnection()) {
            try {
                PreparedStatement pst = null;
                ResultSet rs = null;
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public User getUserByUsername(String usernameToFind) {
        List<User> list = new ArrayList<>();
        list = this.getList();
        User user = new User();
        if (list != null) {
            for (User u : list) {
                if (u.getUsername().equals(usernameToFind)) {
                    user = u;
                }
            }
        }

        return user;
    }

    public void updateUser(User userToUpdate) {
        List<User> list = new ArrayList<>();
        list = this.getList();
        if (userToUpdate != null) {
            for (User u : list) {
                if (u.getUsername().equals(userToUpdate.getUsername())) {
                    setConnection();
                    if (checkConnection()) {
                        try {
                            PreparedStatement pst = null;
                            String sql = "Update Users set password = ? , fullname = ? where username = ? ";
                            int result = -1;
                            pst = conn.prepareStatement(sql);
                            pst.setString(1, userToUpdate.getPassword());
                            pst.setString(2, userToUpdate.getFullname());
                            pst.setString(3, userToUpdate.getUsername());
                            result = pst.executeUpdate();

                        } catch (SQLException ex) {
                        }
                    }
                }
            }
        }
    }

    public void deleteUser(String userToDelete) {
        List<User> list = new ArrayList<>();
        list = this.getList();
        for (User u : list) {
            if (u.getUsername().equals(userToDelete)) {
                setConnection();
                if (checkConnection()) {
                    try {
                        PreparedStatement pst = null;
                        String sql = "Delete from Users where username = ? ";
                        int result = -1;
                        pst = conn.prepareStatement(sql);
                        pst.setString(1, userToDelete);
                        result = pst.executeUpdate();

                    } catch (SQLException ex) {
                    }
                }
            }
        }

    }

}
