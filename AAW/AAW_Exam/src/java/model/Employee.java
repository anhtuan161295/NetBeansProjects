/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author QQ
 */
public class Employee {

    private String EmployeeID;
    private String Password;
    private String Name;
    private int Age;

    public Employee() {
    }

    public Employee(String EmployeeID, String Password, String Name, int Age) {
        this.EmployeeID = EmployeeID;
        this.Password = Password;
        this.Name = Name;
        this.Age = Age;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

}
