/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author QQ
 */
public class UserDAO {

    // Thực thi các thao tác insert, update, delete, select trong csdl trên
    // table Users
    private DBConnection myConnect;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public UserDAO() {
        myConnect = new DBConnection();
        ps = null;
    }

    public DBConnection getDBConnection() {
        return myConnect;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        if (myConnect.openConnect()) {
            try {
                sql = "Select * from [Users]";
                ps = myConnect.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setLevel(rs.getInt("level"));
                    list.add(user);
                }
            } catch (Exception e) {
            } finally {
                myConnect.closeConnect();
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
        }
        return list;
    }

    public boolean addUser(User user) {
        boolean ok = false;
        if (myConnect.openConnect()) {
            try {
                sql = "Insert into [Users] values (?,?,?,?)";
                ps = myConnect.getConnection().prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFullname());
                ps.setInt(4, user.getLevel());
                if (ps.executeUpdate() > 0) {
                    ok = true;
                }
            } catch (Exception e) {
            } finally {
                myConnect.closeConnect();
                try {
                    ps.close();
                } catch (SQLException ex) {
                }
            }
        }
        return ok;
    }

    public boolean deleteUser(String username) {
        boolean ok = false;
        User u = getUserByUsername(username);
        if (u != null) {
            if (myConnect.openConnect()) {
                try {
                    sql = "Delete from [Users] where username = ? ";
                    ps = myConnect.getConnection().prepareStatement(sql);
                    ps.setString(1, username);
                    if (ps.executeUpdate() > 0) {
                        ok = true;
                    }
                } catch (Exception e) {
                } finally {
                    myConnect.closeConnect();
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        }
        return ok;
    }

    public User getUserByUsername(String username) {
        List<User> list = getAll();
        User user = null;
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                user = u;
            }
        }
        return user;
    }

    public boolean updateUser(User user) {
        boolean ok = false;
        User u = getUserByUsername(user.getUsername());
        if (u != null) {
            if (myConnect.openConnect()) {
                try {
                    sql = "Update [Users] set password = ? , fullname = ? , level = ? where username = ? ";
                    ps = myConnect.getConnection().prepareStatement(sql);
                    ps.setString(1, user.getPassword());
                    ps.setString(2, user.getFullname());
                    ps.setInt(3, user.getLevel());
                    ps.setString(4, user.getUsername());
                    if (ps.executeUpdate() > 0) {
                        ok = true;
                    }
                } catch (Exception e) {
                } finally {
                    myConnect.closeConnect();
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        }
        return ok;
    }
}
