/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author QQ
 */
@ManagedBean
@RequestScoped
public class Account {

    @EJB
    private AccountSBLocal accountSB;

    private String name;
    private double amount;
    private int duration;
    private double interest;

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void calculateInterest() {
        interest = accountSB.interest(amount, duration);
//        FacesContext fc = FacesContext.getCurrentInstance();
//        FacesMessage msg = new FacesMessage();
//        msg.setSeverity(msg.SEVERITY_INFO);
//        msg.setSummary("The " + name + "'s interest are " + interest);
//        fc.addMessage("showInterest", msg);
    }

}
