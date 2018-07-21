/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.EmployeeDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@SessionScoped
public class EmployeeMB {

    private Employee emp = new Employee();

    //<editor-fold defaultstate="collapsed" desc="comment">
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public EmployeeMB() {
    }
//</editor-fold>

    public String insertEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        String result = null;
        if (employeeDAO.addEmployee(emp)) {
            result = "ViewAll";
        } else {
            result = "Error";
        }
        return result;
    }

    public List<Employee> listEmployees() {
        EmployeeDAO empDAO = new EmployeeDAO();
        return empDAO.getAll();
    }

    public String login(Employee emp) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        String result = null;
        Employee emp1 = employeeDAO.getEmployee(emp.getEmployeeID());
        if (emp1 != null) {
            if (emp1.getPassword().equals(emp.getPassword())) {
                result = "ViewAll";
            } else {
                // wrong password
                result = "login_error";
            }
        } else {
            // user invalid
            result = "login_error";
        }
        return result;
    }
//    public String logout() {
//        this.emp = new Employee();
//        return "login";
//    }

}
