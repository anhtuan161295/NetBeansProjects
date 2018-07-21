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

    private DBConnection myConnect;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public UserDAO() {
        myConnect = new DBConnection();
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
                    user.setDateofbirth(rs.getString("dateofbirth"));
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));

                    list.add(user);
                }
            } catch (SQLException ex) {
            } finally {
                myConnect.closeConnect();
            }
        }
        return list;
    }

    public User getUser(String username) {
        List<User> list = getAll();
        User user = null;
        for (User u : list) {
            if (u.getUsername().equals(username)) {
                user = u;
            }
        }
        return user;
    }

    public boolean addUser(User user) {
        boolean ok = false;
        if (myConnect.openConnect()) {
            try {
                sql = "Insert into [Users] values (?,?,?,?,?,?)";
                ps = myConnect.getConnection().prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFullname());
                ps.setString(4, user.getDateofbirth());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getRole());

                if (ps.executeUpdate() > 0) {
                    ok = true;
                }
            } catch (Exception e) {
            } finally {
                myConnect.closeConnect();
            }
        }
        return ok;
    }

    public boolean updateUser(User user) {
        User u = getUser(user.getUsername());
        boolean ok = false;
        if (u != null) {
            if (myConnect.openConnect()) {
                try {
                    sql = "Update [Users] set password = ? , fullname = ?, dateofbirth = ?, email = ? where username = ? ";
                    ps = myConnect.getConnection().prepareStatement(sql);
                    ps.setString(1, user.getPassword());
                    ps.setString(2, user.getFullname());
                    ps.setString(3, user.getDateofbirth());
                    ps.setString(4, user.getEmail());
                    ps.setString(5, user.getUsername());
                    if (ps.executeUpdate() > 0) {
                        ok = true;
                    }
                } catch (Exception e) {
                    ok = false;
                } finally {
                    myConnect.closeConnect();
                }
            }
        }
        return ok;
    }

    public boolean deleteUser(String username) {
        boolean ok = false;
        if (myConnect.openConnect()) {
            try {
                sql = "Delete from [Users] where username = ? ";
                ps = myConnect.getConnection().prepareStatement(sql);
                ps.setString(1, username);
                if (ps.executeUpdate() > 0) {
                    ok = true;
                }
            } catch (Exception e) {
                ok = false;
            } finally {
                myConnect.closeConnect();
            }
        }
        return ok;
    }

}
