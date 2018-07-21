/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author QQ
 */
public class AccountDAO {

    private DBConnection myConnect;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public AccountDAO() {
        myConnect = new DBConnection();
        ps = null;
    }

    public DBConnection getDBConnection() {
        return myConnect;
    }

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        if (myConnect.openConnect()) {
            try {
                sql = "Select * from [Account]";
                ps = myConnect.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Account user = new Account();
//                    System.out.println(rs.getString("account_id"));
//                    System.out.println(rs.getString("account_pin"));
//                    System.out.println(rs.getString("account_name"));
//                    System.out.println(rs.getBigDecimal("account_balance").intValue());

                    String str = rs.getString("account_id");
                    String newStr = str.replaceAll("\\s+", "");

                    user.setId(newStr);
                    user.setPin(rs.getString("account_pin"));
                    user.setName(rs.getString("account_name"));
                    user.setBalance(rs.getBigDecimal("account_balance").intValue());
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

    public boolean addUser(Account user) {
        boolean ok = false;
        if (myConnect.openConnect()) {
            try {
                sql = "Insert into [Account] values (?,?,?,?)";
                ps = myConnect.getConnection().prepareStatement(sql);
                ps.setString(1, user.getId());
                ps.setString(2, user.getPin());
                ps.setString(3, user.getName());
                ps.setBigDecimal(4, new BigDecimal(user.getBalance()));
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
        Account u = getUserByUsername(username);
        if (u != null) {
            if (myConnect.openConnect()) {
                try {
                    sql = "Delete from [Account] where account_id = ? ";
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

    public Account getUserByUsername(String username) {
        List<Account> list = getAll();
        Account user = null;
        for (Account u : list) {
            if (u.getId().equals(username)) {
                user = u;
            }
        }
        return user;
    }

    public boolean updateUser(Account user) {
        boolean ok = false;
        Account u = getUserByUsername(user.getId());
        if (u != null) {
            if (myConnect.openConnect()) {
                try {
                    sql = "Update [Account] set account_pin = ? , account_name = ? , account_balance = ? where account_id = ? ";
                    ps = myConnect.getConnection().prepareStatement(sql);
                    ps.setString(1, user.getPin());
                    ps.setString(2, user.getName());
                    ps.setBigDecimal(3, new BigDecimal(user.getBalance()));
                    ps.setString(4, user.getId());
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
