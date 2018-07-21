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
import model.Employee;

/**
 *
 * @author QQ
 */
public class EmployeeDAO {

    // Thực thi các thao tác insert, update, delete, select trong csdl trên
    // table Users
    private DBConnection myConnect;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public EmployeeDAO() {
        myConnect = new DBConnection();
        ps = null;
    }

    public DBConnection getDBConnection() {
        return myConnect;
    }

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        if (myConnect.openConnect()) {
            try {
                sql = "Select * from [Employee]";
                ps = myConnect.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeID(rs.getString("EmployeeID"));
                    emp.setPassword(rs.getString("Password"));
                    emp.setName(rs.getString("Name"));
                    emp.setAge(rs.getInt("Age"));
                    list.add(emp);
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

    public boolean addEmployee(Employee emp) {
        boolean ok = false;
        if (myConnect.openConnect()) {
            try {
                sql = "Insert into [Employee] values (?,?,?,?)";
                ps = myConnect.getConnection().prepareStatement(sql);
                ps.setString(1, emp.getEmployeeID());
                ps.setString(2, emp.getPassword());
                ps.setString(3, emp.getName());
                ps.setInt(4, emp.getAge());
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
    
    public Employee getEmployee(String username) {
        List<Employee> list = getAll();
        Employee user = null;
        for (Employee u : list) {
            if (u.getEmployeeID().equals(username)) {
                user = u;
            }
        }
        return user;
    }

}
