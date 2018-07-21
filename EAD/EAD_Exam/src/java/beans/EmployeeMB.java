/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Employee;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@RequestScoped
public class EmployeeMB {

    @EJB
    private EmployeeFacade employeeFacade;

    Employee emp = new Employee();

    /**
     * Creates a new instance of EmployeeMB
     */
    public EmployeeMB() {
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public String login() {
        boolean ok = employeeFacade.login(emp.getEmployeeID(), emp.getPassword());
        if (ok) {
            return "View?faces-redirect=true";
        } else {
            return "Login?faces-redirect=true";
        }
    }

    public List<Employee> view() {
        return employeeFacade.getAll();
    }

    public String insert() {
        employeeFacade.add(emp);
        emp = new Employee();
        return "View?faces-redirect=true";
    }

}
