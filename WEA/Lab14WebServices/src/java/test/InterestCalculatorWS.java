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
@WebService(serviceName = "InterestCalculatorWS")
@Stateless()
public class InterestCalculatorWS {

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
    @WebMethod(operationName = "simple_interest")
    public Double simple_interest(@WebParam(name = "amount") double amount, @WebParam(name = "rate") double rate, @WebParam(name = "duration") int duration) {
        //TODO write your implementation code here:
        double result = amount * rate * duration;
        return result;
    }
}
