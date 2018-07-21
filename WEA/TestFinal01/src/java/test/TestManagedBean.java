/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@RequestScoped
public class TestManagedBean {

    @EJB
    private TestSessionBeanLocal testSessionBean;

    private String location;
    private double fahrenheit;
    private double celsius;

    public TestManagedBean() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void changeDegree() {
        celsius = testSessionBean.changeDegree(fahrenheit);
    }

}
