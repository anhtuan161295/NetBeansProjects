/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "InterestWS")
@Stateless()
public class InterestWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkAccountNumber")
    public Boolean checkAccountNumber(@WebParam(name = "acc") String acc) {
        //TODO write your implementation code here:
        if (acc.equals("000123456789")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBalance")
    public Double getBalance() {
        //TODO write your implementation code here:
        return (double) 5000;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "interestCalculator")
    public Double interestCalculator(@WebParam(name = "rate") double rate, @WebParam(name = "duration") int duration) {
        //TODO write your implementation code here:

        double result = rate * duration * getBalance();
        return result;
    }
}
