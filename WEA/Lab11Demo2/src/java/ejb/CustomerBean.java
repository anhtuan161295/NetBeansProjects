/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Customer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author QQ
 */
//@Named(value = "customerBean")
@ManagedBean
@RequestScoped
public class CustomerBean {

    @EJB
    private CustomerFacade customerFacade;
    private Customer customer;

    public CustomerBean() {
        this.customer = new Customer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //insert new customer
    public String addCustomer() {
        customerFacade.create(customer);
        return "addOK";
    }

    //delete customer
    public String deleteCustomer(Customer customer) {
        customerFacade.remove(customer);
        return "deleteOK";
    }

    //find customer
    public String findCustomer(Customer customer) {
        Customer c = customerFacade.find(customer);
        if (c != null) {
            return "findOK";
        } else {
            return "findNO";
        }

    }

    //edit customer
    public String editCustomer(Customer customer) {
        customerFacade.edit(customer);
        return "editOK";
    }

}
